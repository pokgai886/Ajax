package day05;

import java.util.Scanner;

public class badboy {
	
	private Girlfriend[] girl=new Girlfriend[3];
	
	public void setGirl() {
		Scanner sc=new Scanner(System.in);
		
		
		for(int i=0;i<girl.length;i++) {
			System.out.println("�������"+(i+1)+"��Ů���ѵ�����");
			String name=sc.next();
			Girlfriend gf=new Girlfriend();
			gf.setName(name);
			girl[i]=gf;
		}
		
	}
	public void showGirl() {
		for (Girlfriend g : girl) {
			System.out.println(g);
		}
		
	}
}
