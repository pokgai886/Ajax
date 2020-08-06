package day16网络编程;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
/**
 * 专门设置一个线程:读取来自服务器的消息
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
		// 只要不断读服务器的消息
		while(true) {
			//2.2 接受服务器的消息  读
			try {
				dis=new DataInputStream(client.getInputStream());
				String str=dis.readUTF();
				System.out.println("收到服务器发来的消息:"+str);
			
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("读取服务器消息失败,该客户端已经下线");
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
		System.out.println("这是客户端!!");
		Socket client=null;
		//1.实例化客户端Socket并连接服务器
		try {
			client=new Socket("127.0.0.1",7777);//服务端IP与端口号
			System.out.println("连接成功");
			//群聊提升点:只要能够和服务器连接,就应该开始接收服务器下推的消息,启动线程来读取服务器的消息
			new ReadServerThread(client).start();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("连接失败");
		}
		//2与服务端进行交互
		
		
			try {
				System.out.println("请输入信息,按quit退出");
				Scanner sc=new Scanner(System.in);
				String str=sc.nextLine();
				DataOutputStream dos=null;
			//	DataInputStream dis=null;
				while(!str.equalsIgnoreCase("quit")) {

					//2.1向服务器发送消息  写
				//	创建写数据的流,接受当前客户端写入的信息
					dos=new DataOutputStream(client.getOutputStream());
					dos.writeUTF(str);
//					//接受服务器的消息   读
//					dis=new DataInputStream(client.getInputStream());
//					str=dis.readUTF();
				//	System.out.println("收到服务器发来的消息:"+str);
					System.out.println("请输入信息,按quit退出");
					str=sc.nextLine();
				}
				//3.关闭对象
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


