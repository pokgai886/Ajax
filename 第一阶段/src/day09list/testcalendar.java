package day09list;

import java.util.Calendar;
import java.util.Scanner;

public class testcalendar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar now=Calendar.getInstance();
		System.out.println("��ȡ��ǰʱ��:");
		System.out.println(now.get(Calendar.YEAR)+"��");
		System.out.println((now.get(Calendar.MONTH))+"��");
		
		System.out.println("������ʱ��");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		int j=sc.nextInt();
		int k=sc.nextInt();
		
		now.set(Calendar.YEAR, i);
		now.set(Calendar.MONTH, j);//��ʾ
		now.set(Calendar.DATE, k);
		
		System.out.print(now.get(Calendar.YEAR)+"��");
		System.out.print((now.get(Calendar.MONTH)+1)+"��");
		System.out.println(now.get(Calendar.DATE)+"��");
		
	
	}

}
