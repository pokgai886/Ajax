package day11dept;

import java.util.ArrayList;
import java.util.Scanner;

public class deptManage {
	
	private ArrayList<Dept> depts=new ArrayList<Dept>();
	
	/**
	 * ���Ӳ���
	 * 
	 */
	public void addDept(Dept dept) {
		depts.add(dept);
		System.out.println("���ӳɹ�");

	}
	public void inputDept() {
		System.out.println("**�����벿�ű��,��������,��������** ");
		Scanner sc=new Scanner(System.in);
		int deptNo=sc.nextInt();
		String deptName=sc.next();
		String deptDesc=sc.next();
		Dept dept=new Dept(deptNo,deptName,deptDesc);
		addDept(dept);
	}
	
	/**
	 * �޸Ĳ�����Ϣ
	 */
	public void xiugaiDept(Dept dept) {
		boolean flag=false;
		for(int i=0;i<depts.size();i++) {
			Dept dt=depts.get(i);
			if(dt.getDeptNo()== dept.getDeptNo()) {
				flag=true;
				dt.setDeptNo(dept.getDeptNo());
				dt.setDeptName(dept.getDeptName());
				dt.setDeptDesc(dept.getDeptDesc());
			}
		}
		if(flag) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
		
	}
	//�޸�
	public void xgDept() {
		
		System.out.println("**������Ҫ�޸ĵĲ�����Ϣ** ");
		Scanner sc=new Scanner(System.in);
		int deptNo=sc.nextInt();
		String deptName=sc.next();
		String deptDesc=sc.next();
		Dept dept=new Dept(deptNo,deptName,deptDesc);
		xiugaiDept(dept);
	}
	
	/**
	 * ɾ��������Ϣ
	 */
	public void deleMenu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****������Ҫɾ���Ĳ��ű��******");
		int deptno=sc.nextInt();
		//deleEmp(empno);
		deleDept1(deptno);
	}
	public void deleDept(int deptNo) {
		boolean flag=false;//ɾ��ʧ��
		for (int i = 0; i < depts.size(); i++) {
			if(deptNo==depts.get(i).getDeptNo()) {
				flag=true;//ɾ���ɹ�
				depts.remove(depts.get(i));
				i--;
			}
		}
		if(flag) {
			System.out.println("ɾ���ɹ�!");
		}else {
			System.out.println("ɾ��ʧ��!");
		}
	}
	public void deleDept1(int deptNo) {
		boolean flag=false;
		ArrayList<Dept> deptss=new ArrayList<Dept>();
		
		for (Dept dept : depts) {
			if(deptNo!=dept.getDeptNo()) {
				deptss.add(dept);
			}else {
				flag=true;
			}
			
		}
		depts=deptss;
		if(flag) {
			System.out.println("�ɹ�");
		}else {
			System.out.println("ʧ��");
		}
		
	}
	
	/**
	 * ��ʾ���в�����Ϣ
	 */
	public void showDept() {
		for (Dept dept : depts) {
			System.out.println(dept);
		}
		
	}
	
	/**
	 * ���˵�
	 */
	public void showMenu() {
		while(1==1) {
			System.out.println("����0�˳�,1���Ӳ���,2ɾ������,3�޸Ĳ���,4��ʾ���в���");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			switch (n) {
			case 0:
				System.out.println("�ɹ��˳�ϵͳ");
				System.exit(0);
				break;
			case 1:
				inputDept();
				break;
			case 2:
				deleMenu();
				break;
			case 3:
				xgDept();
				break;
			case 4:
				showDept();
				break;

			default:
				break;
			}
		}
	}
	
}
