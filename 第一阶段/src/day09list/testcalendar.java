package day09list;

import java.util.Calendar;
import java.util.Scanner;

public class testcalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar now=Calendar.getInstance();
		System.out.println("获取当前时间:");
		System.out.println(now.get(Calendar.YEAR)+"年");
		System.out.println((now.get(Calendar.MONTH))+"月");
		
		System.out.println("请设置时间");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		int j=sc.nextInt();
		int k=sc.nextInt();
		
		now.set(Calendar.YEAR, i);
		now.set(Calendar.MONTH, j);//显示
		now.set(Calendar.DATE, k);
		
		System.out.print(now.get(Calendar.YEAR)+"年");
		System.out.print((now.get(Calendar.MONTH)+1)+"月");
		System.out.println(now.get(Calendar.DATE)+"日");
		
	
	}

}
