package day08��ҵ;

import java.util.Scanner;

public class person extends player {
	
	public person() {
		
	}
	public person(String name,int score) {
		//���ݸ�����
		super(name,score);
	}
	@Override
	public int showfist() {
		// TODO Auto-generated method stub
		System.out.println("������:1 ʯͷ,2 ����,3��");
		Scanner sc=new Scanner(System.in);
		int fist=sc.nextInt();
		return fist;
	}
}
