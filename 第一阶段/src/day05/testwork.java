package day05;

import java.util.Scanner;

public class testwork {
	public static void main(String[] args) {
		work tw=new work();
		tw.setAdmin("����");
		tw.setPwd("123456");
		System.out.println("�������û���������");
		Scanner sc= new Scanner(System.in);
		String name=sc.next();
		String upwd=sc.next();
		boolean flag=tw.login(name,upwd);
		if(flag) {
			System.out.println("��¼�ɹ�");
		}else {
			System.out.println("��¼ʧ��");
		}
	}
	
	
}
