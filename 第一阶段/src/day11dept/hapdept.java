package day11dept;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class hapdept {
	private HashMap<Integer,Dept> depts=new HashMap<Integer,Dept>();
	/**
	 * ���Ӳ���
	 */
	public void addDept(Dept dept) {
		depts.put(dept.getDeptNo(), dept);
		System.out.println("���ӳɹ�");
	}
	public void inputDept() {
		System.out.println("�����벿�ű��,��������,��������");
		Scanner sc=new Scanner(System.in);
		int deptNo=sc.nextInt();
		String deptName=sc.next();
		String deptDesc=sc.next();
		Dept dept=new Dept(deptNo,deptName,deptDesc);
		addDept(dept);
	}
	//��ʾ����
	public void showDept(){
		Iterator<Integer> itor=depts.keySet().iterator();
		while(itor.hasNext()) {
			Integer key=itor.next();
			System.out.println(depts.get(key).toString());
		}
	}
	
}
