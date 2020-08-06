package day15线程;

import java.util.Random;

public class ModifyPerson extends Thread {
	private Person p;
	int n;
	//要给p赋值,写一个构造方法
	public ModifyPerson(Person p) {
		super();
		this.p = p;
	}
	public void modify() {
		n=new Random().nextInt(100);
	}
	
}
