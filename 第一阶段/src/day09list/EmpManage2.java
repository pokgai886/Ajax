package day09list;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpManage2 {
	//�м���Ա��
	private ArrayList<Emp> emps=new ArrayList<Emp>();
	
	/**
	 * ����Ա��
	 */
	public void addEmp(Emp emp) {
		emps.add(emp);
		System.out.println("���ӳɹ�");
	}
	/**
	 * ����Ա��
	 */
	public void inputEmp() {
		System.out.println("****������Ա�����,����,����,��������****");
		Scanner sc=new Scanner(System.in);
		int empNo=sc.nextInt();
		String empName=sc.next();
		String deptName=sc.next();
		double salary=sc.nextDouble();
		
		
		Emp emp=new Emp(empNo, empName, deptName, salary);
		addEmp(emp);
	}
	/**
	 * ��ʾ����Ա��
	 */
	public void showEmp() {
		System.out.println("****��˾Ա���б�����****");
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	/**
	 * ����Ա��
	 */
	public void findEmp(int empNo) {
		boolean flag=false;//����û�ҵ�
		for (Emp emp : emps) {
			
				if(emp.getEmpNo()==empNo) {
					flag=true;
					System.out.println(emp);
					break;
				}
			
		}
		if(!flag) {
			System.out.println("���޴���");
		}
	}
	//����Ա����Ų�ѯԱ��
	public void findMenu() {
		System.out.println("****������Ҫ��ѯԱ���ı��****");
		Scanner sc=new Scanner(System.in);
		int empno=sc.nextInt();
		findEmp(empno);
	}
	/**
	 * ɾ��Ա��
	 */
	public void delete(int empno) {
		boolean flag=false;//ɾ��ʧ��
		for(int i=0;i<emps.size();i++) {
			if(empno==((Emp) emps.get(i)).getEmpNo()) {
				flag=true;//ɾ���ɹ�
				emps.remove(emps.get(i));
				i--;
				
			}
			if(flag) {
				System.out.println("ɾ���ɹ�");
			}else {
				System.out.println("ɾ��ʧ��");
			}
		
		}
		
		}
	//ɾ��Ա��
	public void dele() {
		System.out.println("������Ҫɾ��Ա���ı��");
		Scanner sc=new Scanner(System.in);
		int empno=sc.nextInt();
		delete(empno);
	}
	/**
	 * �޸�Ա��
	 */
	public void updapt() {
		System.out.println("****������Ҫ�޸ĵ�Ա����Ϣ****");
		Scanner sc=new Scanner(System.in);
		int empNo=sc.nextInt();
		String empName=sc.next();
		String deptName=sc.next();
		double salary=sc.nextDouble();
		
		
		Emp emp=new Emp(empNo, empName, deptName, salary);
		updaptEmp(emp);
	}
		
		
	
	
	
	public void updaptEmp(Emp emp) {
		// TODO Auto-generated method stub
		boolean flag=true;
		for(int i=0;i<emps.size();i++) {
			Emp emp1=emps.get(i);
			if(emp1.getEmpNo()==emp.getEmpNo()) {
				flag=true;
				emp1.setEmpName(emp.getEmpName());
				emp1.setDeptName(emp.getDeptName());
				emp1.setSalary(emp.getSalary());
			}
		}
		if(flag) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
	}
	/**
	 * 
	 * �˵�����
	 */
	public void caidan() {
		while(1==1) {
		System.out.println("������:1 ����Ա��,2 ��ѯԱ��,3 ��ʾ����Ա��,4 �޸�Ա��,5 ɾ��Ա��");
		Scanner sc=new Scanner(System.in);
		int i=sc.nextInt();
		switch (i) {
		case 1:
			inputEmp();
			break;
			
		case 2:
			findMenu();
			break;
			
		case 3:
			showEmp();
			break;
			
		case 4:
			updapt();
			break;
			
		case 5:
			dele();
			break;

		default:
			break;
		}
	}
	}
}

