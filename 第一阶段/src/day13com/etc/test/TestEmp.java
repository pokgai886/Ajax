package day13com.etc.test;


import java.util.List;
import java.util.Scanner;

import day13com.etc.dao.EmpDao_UseUtil;
import day13com.etc.entity.Emp;
import day13com.etc.menu.EmpMenu;


public class TestEmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		EmpDao empdao=new EmpDao();
//		List<Emp> list=empdao.queryAll();
//		for (Emp emp : list) {
//			System.out.println(emp);
		
	//	}
//		EmpDao_UseUtil empdao=new EmpDao_UseUtil();
//		List<Emp> list=empdao.queryAll();
//		for (Emp emp : list) {
//		System.out.println(emp);	
//		}
		
//		System.out.println("������Ҫ�޸ĵ�Ա����ź���Ϣ");
//		Scanner sc=new Scanner(System.in);
//		int empNo=sc.nextInt();
//		String empName=sc.next();
//		int deptNo=sc.nextInt();
//		double salary=sc.nextDouble();
//		
//		Emp emp=new Emp(empNo,empName,deptNo,salary);
//		
//		boolean flag=empdao.updapt(emp);
//		if(flag) {
//			System.out.println("�޸ĳɹ�");
//		}else {
//			System.out.println("�޸�ʧ��");
//		}
//		boolean flag=empdao.deleEmp(empNo);
//		System.out.println(flag);
//		if(flag) {
//			System.out.println("ɾ���ɹ�");
//		}else {
//			System.out.println("ɾ��ʧ��");
//		}
		//sc.close();
		EmpMenu em=new EmpMenu();
		em.shoewMenu();
	}

}
