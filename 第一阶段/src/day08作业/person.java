package day08作业;

import java.util.Scanner;

public class person extends player {
	
	public person() {
		
	}
	public person(String name,int score) {
		//传递给父类
		super(name,score);
	}
	@Override
	public int showfist() {
		// TODO Auto-generated method stub
		System.out.println("请输入:1 石头,2 剪刀,3布");
		Scanner sc=new Scanner(System.in);
		int fist=sc.nextInt();
		return fist;
	}
}
