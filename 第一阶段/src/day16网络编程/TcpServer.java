package day16网络编程;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

class MyChatThread extends Thread{
	private Socket client;//客户端
	//传递调用该线程的客户端
	//构造方法
	public MyChatThread(Socket client) {
		this.client=client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//不停的读和写
		DataInputStream dis=null;
		DataOutputStream dos=null;
		try {
			dis=new DataInputStream(client.getInputStream());
			while(true) {
				//读
				String str=dis.readUTF();
				System.out.println("服务端接受来自客户端:"+client.getRemoteSocketAddress()+"的消息"+str);
				//写
				//群聊提升点3:之前只要发给一个客户端,现在要发给多个客户端
				synchronized(TcpServer.clientList) {
					for (Socket c : TcpServer.clientList) {
						//写给每一个客户端,所有获取每个客户端的输出流
						dos=new DataOutputStream(c.getOutputStream());
						//发送指定客户端说的话
						dos.writeUTF(client.getRemoteSocketAddress()+"发言"+str);
					}
				}
				
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(client.getRemoteSocketAddress()+"已下线");
			//群聊提升点2:当有人下线,就要从集合中删除
			synchronized (TcpServer.clientList) {
				TcpServer.clientList.remove(client);
				System.out.println("当前客户端个数:"+TcpServer.clientList.size());
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
	public static List<Socket> clientList=new ArrayList<>();//存储所有的客户端
	public static void testServer() {
		// TODO Auto-generated method stub
		System.out.println("这是服务器!!");
		int port=7777;
		//1.启动监听
		ServerSocket server=null;
		Socket client=null;
		try {
			server=new ServerSocket(port);
			System.out.println("服务器在"+port+"端口启动监听成功");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("服务器在"+port+"端口启动监听失败");
		}
		//2.等待客户端连接
//		DataInputStream dis=null;
//		DataOutputStream dos=null;
		while(true) {
			try {
				System.out.println("服务器准备等待客户端连接...");
				client=server.accept();//阻塞,返回一个客户端
				System.out.println("来自客户端IP为:"+client.getRemoteSocketAddress()+"的连接");
				//群聊提升点1:一旦有人连接上来,就要存到集合中
				//锁:为了避免同时操作删除和增加
				synchronized (clientList) {
					clientList.add(client);
					System.out.println("当前客户端个数:"+clientList.size());
				}
				
				//创建线程
				MyChatThread t=new MyChatThread(client);
				t.start();
				
//				while(true) {
//					//3.数据传输 两端交互
//					//3.1接受客户端信息 读
//					//client.getInputStream()把读取的内容给dis
//					dis=new DataInputStream(client.getInputStream());
//					String str=dis.readUTF();
//					System.out.println("服务端接受来自客户端:"+client.getRemoteSocketAddress()+"的消息"+str);
//					//3.2 下推信息给客户端 写
//					dos=new DataOutputStream(client.getOutputStream());
//					dos.writeUTF(str);//str写进流管道中
//				
//				}
				
				 
			}catch (EOFException e) {
				
			  System.out.println("客户端断开连接!");
			
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

