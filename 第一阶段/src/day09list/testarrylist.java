package day09list;

import java.util.ArrayList;
import java.util.Date;

public class testarrylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList at=new ArrayList();
		at.add(new Date());
		at.add("好好学习");
		at.add(12.33);
		at.remove("好好学习");
		at.remove("好好学");
		
		if(at.contains(12.33)) {
			System.out.println("找到了12.33");
		}
		for(int i=0;i<at.size();i++) {
		System.out.println(at.get(i));
		}
	}

}
