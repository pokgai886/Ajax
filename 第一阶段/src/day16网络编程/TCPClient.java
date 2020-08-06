package day16������;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
/**
 * ר������һ���߳�:��ȡ���Է���������Ϣ
 * @author Administrator
 *
 */
class ReadServerThread extends Thread{
	private Socket client;
	public ReadServerThread(Socket client) {
		super();
		this.client=client;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		DataInputStream dis=null;
		// ֻҪ���϶�����������Ϣ
		while(true) {
			//2.2 ���ܷ���������Ϣ  ��
			try {
				dis=new DataInputStream(client.getInputStream());
				String str=dis.readUTF();
				System.out.println("�յ���������������Ϣ:"+str);
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("��ȡ��������Ϣʧ��,�ÿͻ����Ѿ�����");
				break;
			}
		}
		
			try {
				if(null!=dis)
				dis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
public class TCPClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("���ǿͻ���!!");
		Socket client=null;
		//1.ʵ�����ͻ���Socket�����ӷ�����
		try {
			client=new Socket("127.0.0.1",7777);//�����IP��˿ں�
			System.out.println("���ӳɹ�");
			//Ⱥ��������:ֻҪ�ܹ��ͷ���������,��Ӧ�ÿ�ʼ���շ��������Ƶ���Ϣ,�����߳�����ȡ����������Ϣ
			new ReadServerThread(client).start();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
		//2�����˽��н���
		
		
			try {
				System.out.println("��������Ϣ,��quit�˳�");
				Scanner sc=new Scanner(System.in);
				String str=sc.nextLine();
				DataOutputStream dos=null;
			//	DataInputStream dis=null;
				while(!str.equalsIgnoreCase("quit")) {

					//2.1�������������Ϣ  д
				//	����д���ݵ���,���ܵ�ǰ�ͻ���д�����Ϣ
					dos=new DataOutputStream(client.getOutputStream());
					dos.writeUTF(str);
//					//���ܷ���������Ϣ   ��
//					dis=new DataInputStream(client.getInputStream());
//					str=dis.readUTF();
				//	System.out.println("�յ���������������Ϣ:"+str);
					System.out.println("��������Ϣ,��quit�˳�");
					str=sc.nextLine();
				}
				//3.�رն���
//				if(null!=dis) 
//				dis.close();
				if(null!=dos) 
				dos.close();
				client.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


