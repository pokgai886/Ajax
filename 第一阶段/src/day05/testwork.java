package day05;

import java.util.Scanner;

public class testwork {
	public static void main(String[] args) {
		work tw=new work();
		tw.setAdmin("老王");
		tw.setPwd("123456");
		System.out.println("请输入用户名和密码");
		Scanner sc= new Scanner(System.in);
		String name=sc.next();
		String upwd=sc.next();
		boolean flag=tw.login(name,upwd);
		if(flag) {
			System.out.println("登录成功");
		}else {
			System.out.println("登录失败");
		}
	}
	
	
}
