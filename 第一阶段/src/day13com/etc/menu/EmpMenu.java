package day13com.etc.menu;

import java.util.List;
import java.util.Scanner;

import day13com.etc.dao.EmpDao_UseUtil;
import day13com.etc.entity.Emp;

public class EmpMenu {
	public void shoewMenu() {
		while(1==1) {
			System.out.println("������0�˳�,1����Ա��,2ɾ��Ա��,3�޸�Ա��,4��ʾ����Ա��,5���ݲ��ű�Ų�ѯԱ��");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			switch (n) {
			case 0:
				System.out.println("���ѳɹ��˳�ϵͳ");
				System.exit(0);
				break;
			case 1:
				addMenu();
				break;
			case 2:
				deleMenu();
				break;
			case 3:
				updateMenu();
				break;	
			case 4:
				showAllEmp();
				break;	
			case 5:
				showAllEmp1();
				break;
			default:
				break;
			}
			
		}
	}
	//����Ա��
	private void addMenu() {
		System.out.println("������Ҫ���ӵ�Ա����Ϣ(���� ���ű�� ����)");
		Scanner sc=new Scanner(System.in);
		String empName=sc.next();
		int deptNo=sc.nextInt();
		double salary=sc.nextDouble();
		Emp emp=new Emp(empName,deptNo,salary);
		EmpDao_UseUtil empdao=new EmpDao_UseUtil();
		boolean flag=empdao.addEmp(emp);
		if(flag) {
			System.out.println("���ӳɹ�");
		}else {
			System.out.println("����ʧ��");
		}
		
	}
	//ɾ��Ա��
	private void deleMenu() {
		System.out.println("������Ҫɾ����Ա�����");
		Scanner sc=new Scanner(System.in);
		int empNo=sc.nextInt();
		EmpDao_UseUtil empdao=new EmpDao_UseUtil();
		boolean flag=empdao.deleEmp(empNo);
		if(flag) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
	}
	//�޸�Ա��
	private void updateMenu() {
		System.out.println("������Ҫ�޸ĵ�Ա����Ϣ(��� ���� ���ű�� ����)");
		Scanner sc=new Scanner(System.in);
		int empNo=sc.nextInt();
		String empName=sc.next();
		int deptNo=sc.nextInt();
		double salary=sc.nextDouble();
		Emp emp=new Emp(empNo,empName,deptNo,salary);
		EmpDao_UseUtil empdao=new EmpDao_UseUtil();
		boolean flag=empdao.updapt(emp);
		if(flag) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	//��ѯԱ��
	private void showAllEmp() {
		EmpDao_UseUtil empdao=new EmpDao_UseUtil();
		List<Emp> list=empdao.queryAll();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//���ղ��ű�Ų�ѯԱ��
		private void showAllEmp1() {
			System.out.println("�����벿�ű��");
			Scanner sc=new Scanner(System.in);
			int deptNo=sc.nextInt();
			EmpDao_UseUtil empdao=new EmpDao_UseUtil();
			List<Emp> list=empdao.queryAll1(deptNo);
			for (Emp emp : list) {
				System.out.println(emp);
			}
		}
}
