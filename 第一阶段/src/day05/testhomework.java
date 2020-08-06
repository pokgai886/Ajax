package day05;

import java.util.Scanner;

public class testhomework {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		homework hm=new homework();
		hm.setBoy("Ð¡Ã÷");
		hm.setGril("Ð¡ºì");
		hm.boy();
		hm.gril();
		Scanner sc=new Scanner(System.in);
		String boy1=sc.next();
		System.out.println(hm.getBoy()+":"+boy1);
		String gril1=sc.next();
	
		System.out.println(hm.getGril()+":"+gril1);
	}

}
