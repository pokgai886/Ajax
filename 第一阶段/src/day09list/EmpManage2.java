package day09list;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpManage2 {
	//有几个员工
	private ArrayList<Emp> emps=new ArrayList<Emp>();
	
	/**
	 * 新增员工
	 */
	public void addEmp(Emp emp) {
		emps.add(emp);
		System.out.println("增加成功");
	}
	/**
	 * 输入员工
	 */
	public void inputEmp() {
		System.out.println("****请输入员工编号,姓名,部门,基本工资****");
		Scanner sc=new Scanner(System.in);
		int empNo=sc.nextInt();
		String empName=sc.next();
		String deptName=sc.next();
		double salary=sc.nextDouble();
		
		
		Emp emp=new Emp(empNo, empName, deptName, salary);
		addEmp(emp);
	}
	/**
	 * 显示所有员工
	 */
	public void showEmp() {
		System.out.println("****公司员工列表如下****");
		for (Emp emp : emps) {
			System.out.println(emp);
		}
	}
	/**
	 * 查找员工
	 */
	public void findEmp(int empNo) {
		boolean flag=false;//代表没找到
		for (Emp emp : emps) {
			
				if(emp.getEmpNo()==empNo) {
					flag=true;
					System.out.println(emp);
					break;
				}
			
		}
		if(!flag) {
			System.out.println("查无此人");
		}
	}
	//根据员工编号查询员工
	public void findMenu() {
		System.out.println("****请输入要查询员工的编号****");
		Scanner sc=new Scanner(System.in);
		int empno=sc.nextInt();
		findEmp(empno);
	}
	/**
	 * 删除员工
	 */
	public void delete(int empno) {
		boolean flag=false;//删除失败
		for(int i=0;i<emps.size();i++) {
			if(empno==((Emp) emps.get(i)).getEmpNo()) {
				flag=true;//删除成功
				emps.remove(emps.get(i));
				i--;
				
			}
			if(flag) {
				System.out.println("删除成功");
			}else {
				System.out.println("删除失败");
			}
		
		}
		
		}
	//删除员工
	public void dele() {
		System.out.println("请输入要删除员工的编号");
		Scanner sc=new Scanner(System.in);
		int empno=sc.nextInt();
		delete(empno);
	}
	/**
	 * 修改员工
	 */
	public void updapt() {
		System.out.println("****请输入要修改的员工信息****");
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
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	/**
	 * 
	 * 菜单功能
	 */
	public void caidan() {
		while(1==1) {
		System.out.println("请输入:1 增加员工,2 查询员工,3 显示所有员工,4 修改员工,5 删除员工");
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

