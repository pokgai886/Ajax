package day09list;

import java.util.ArrayList;
import java.util.Date;

public class testarrylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList at=new ArrayList();
		at.add(new Date());
		at.add("�ú�ѧϰ");
		at.add(12.33);
		at.remove("�ú�ѧϰ");
		at.remove("�ú�ѧ");
		
		if(at.contains(12.33)) {
			System.out.println("�ҵ���12.33");
		}
		for(int i=0;i<at.size();i++) {
		System.out.println(at.get(i));
		}
	}

}
