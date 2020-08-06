package day16������;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class MyChatThread extends Thread{
	private Socket client;//�ͻ���
	//���ݵ��ø��̵߳Ŀͻ���
	//���췽��
	public MyChatThread(Socket client) {
		this.client=client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//��ͣ�Ķ���д
		DataInputStream dis=null;
		DataOutputStream dos=null;
		try {
			dis=new DataInputStream(client.getInputStream());
			while(true) {
				//��
				String str=dis.readUTF();
				System.out.println("����˽������Կͻ���:"+client.getRemoteSocketAddress()+"����Ϣ"+str);
				//д
				//Ⱥ��������3:֮ǰֻҪ����һ���ͻ���,����Ҫ��������ͻ���
				synchronized(TcpServer.clientList) {
					for (Socket c : TcpServer.clientList) {
						//д��ÿһ���ͻ���,���л�ȡÿ���ͻ��˵������
						dos=new DataOutputStream(c.getOutputStream());
						//����ָ���ͻ���˵�Ļ�
						dos.writeUTF(client.getRemoteSocketAddress()+"����"+str);
					}
				}
				
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(client.getRemoteSocketAddress()+"������");
			//Ⱥ��������2:����������,��Ҫ�Ӽ�����ɾ��
			synchronized (TcpServer.clientList) {
				TcpServer.clientList.remove(client);
				System.out.println("��ǰ�ͻ��˸���:"+TcpServer.clientList.size());
			}
		
		}finally {
			
				try {
					if(null!=dos)
						dos.close();
					if(null!=dis)
						dis.close();
					if(null!=client)
						client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		
	}
}

public class TcpServer {
	public static List<Socket> clientList=new ArrayList<>();//�洢���еĿͻ���
	public static void testServer() {
		// TODO Auto-generated method stub
		System.out.println("���Ƿ�����!!");
		int port=7777;
		//1.��������
		ServerSocket server=null;
		Socket client=null;
		try {
			server=new ServerSocket(port);
			System.out.println("��������"+port+"�˿����������ɹ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��������"+port+"�˿���������ʧ��");
		}
		//2.�ȴ��ͻ�������
//		DataInputStream dis=null;
//		DataOutputStream dos=null;
		while(true) {
			try {
				System.out.println("������׼���ȴ��ͻ�������...");
				client=server.accept();//����,����һ���ͻ���
				System.out.println("���Կͻ���IPΪ:"+client.getRemoteSocketAddress()+"������");
				//Ⱥ��������1:һ��������������,��Ҫ�浽������
				//��:Ϊ�˱���ͬʱ����ɾ��������
				synchronized (clientList) {
					clientList.add(client);
					System.out.println("��ǰ�ͻ��˸���:"+clientList.size());
				}
				
				//�����߳�
				MyChatThread t=new MyChatThread(client);
				t.start();
				
//				while(true) {
//					//3.���ݴ��� ���˽���
//					//3.1���ܿͻ�����Ϣ ��
//					//client.getInputStream()�Ѷ�ȡ�����ݸ�dis
//					dis=new DataInputStream(client.getInputStream());
//					String str=dis.readUTF();
//					System.out.println("����˽������Կͻ���:"+client.getRemoteSocketAddress()+"����Ϣ"+str);
//					//3.2 ������Ϣ���ͻ��� д
//					dos=new DataOutputStream(client.getOutputStream());
//					dos.writeUTF(str);//strд�����ܵ���
//				
//				}
				
				 
			}catch (EOFException e) {
				
			  System.out.println("�ͻ��˶Ͽ�����!");
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}/*finally {
				
					try {
						if(null!=dis)
						dis.close();
						if(null!=dos)
						dos.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}*/
		}
	}
	public static void main(String[] args) {
		testServer();
	}

}

