package day15�߳�;

import java.util.Random;

public class ModifyPerson extends Thread {
	private Person p;
	int n;
	//Ҫ��p��ֵ,дһ�����췽��
	public ModifyPerson(Person p) {
		super();
		this.p = p;
	}
	public void modify() {
		n=new Random().nextInt(100);
	}
	
}
