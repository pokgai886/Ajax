package day13com.etc.menu;

import java.util.List;
import java.util.Scanner;

import day13com.etc.dao.EmpDao_UseUtil;
import day13com.etc.entity.Emp;

public class EmpMenu {
	public void shoewMenu() {
		while(1==1) {
			System.out.println("请输入0退出,1增加员工,2删除员工,3修改员工,4显示所有员工,5根据部门编号查询员工");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			switch (n) {
			case 0:
				System.out.println("您已成功退出系统");
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
	//增加员工
	private void addMenu() {
		System.out.println("请输入要增加的员工信息(姓名 部门编号 工资)");
		Scanner sc=new Scanner(System.in);
		String empName=sc.next();
		int deptNo=sc.nextInt();
		double salary=sc.nextDouble();
		Emp emp=new Emp(empName,deptNo,salary);
		EmpDao_UseUtil empdao=new EmpDao_UseUtil();
		boolean flag=empdao.addEmp(emp);
		if(flag) {
			System.out.println("增加成功");
		}else {
			System.out.println("增加失败");
		}
		
	}
	//删除员工
	private void deleMenu() {
		System.out.println("请输入要删除的员工编号");
		Scanner sc=new Scanner(System.in);
		int empNo=sc.nextInt();
		EmpDao_UseUtil empdao=new EmpDao_UseUtil();
		boolean flag=empdao.deleEmp(empNo);
		if(flag) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
	}
	//修改员工
	private void updateMenu() {
		System.out.println("请输入要修改的员工信息(编号 姓名 部门编号 工资)");
		Scanner sc=new Scanner(System.in);
		int empNo=sc.nextInt();
		String empName=sc.next();
		int deptNo=sc.nextInt();
		double salary=sc.nextDouble();
		Emp emp=new Emp(empNo,empName,deptNo,salary);
		EmpDao_UseUtil empdao=new EmpDao_UseUtil();
		boolean flag=empdao.updapt(emp);
		if(flag) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
	}
	//查询员工
	private void showAllEmp() {
		EmpDao_UseUtil empdao=new EmpDao_UseUtil();
		List<Emp> list=empdao.queryAll();
		for (Emp emp : list) {
			System.out.println(emp);
		}
	}
	//按照部门编号查询员工
		private void showAllEmp1() {
			System.out.println("请输入部门编号");
			Scanner sc=new Scanner(System.in);
			int deptNo=sc.nextInt();
			EmpDao_UseUtil empdao=new EmpDao_UseUtil();
			List<Emp> list=empdao.queryAll1(deptNo);
			for (Emp emp : list) {
				System.out.println(emp);
			}
		}
}
