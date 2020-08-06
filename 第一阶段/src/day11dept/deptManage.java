package day11dept;

import java.util.ArrayList;
import java.util.Scanner;

public class deptManage {
	
	private ArrayList<Dept> depts=new ArrayList<Dept>();
	
	/**
	 * 增加部门
	 * 
	 */
	public void addDept(Dept dept) {
		depts.add(dept);
		System.out.println("增加成功");

	}
	public void inputDept() {
		System.out.println("**请输入部门编号,部门名称,部门描述** ");
		Scanner sc=new Scanner(System.in);
		int deptNo=sc.nextInt();
		String deptName=sc.next();
		String deptDesc=sc.next();
		Dept dept=new Dept(deptNo,deptName,deptDesc);
		addDept(dept);
	}
	
	/**
	 * 修改部门信息
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
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
	}
	//修改
	public void xgDept() {
		
		System.out.println("**请输入要修改的部门信息** ");
		Scanner sc=new Scanner(System.in);
		int deptNo=sc.nextInt();
		String deptName=sc.next();
		String deptDesc=sc.next();
		Dept dept=new Dept(deptNo,deptName,deptDesc);
		xiugaiDept(dept);
	}
	
	/**
	 * 删除部门信息
	 */
	public void deleMenu() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****请输入要删除的部门编号******");
		int deptno=sc.nextInt();
		//deleEmp(empno);
		deleDept1(deptno);
	}
	public void deleDept(int deptNo) {
		boolean flag=false;//删除失败
		for (int i = 0; i < depts.size(); i++) {
			if(deptNo==depts.get(i).getDeptNo()) {
				flag=true;//删除成功
				depts.remove(depts.get(i));
				i--;
			}
		}
		if(flag) {
			System.out.println("删除成功!");
		}else {
			System.out.println("删除失败!");
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
			System.out.println("成功");
		}else {
			System.out.println("失败");
		}
		
	}
	
	/**
	 * 显示所有部门信息
	 */
	public void showDept() {
		for (Dept dept : depts) {
			System.out.println(dept);
		}
		
	}
	
	/**
	 * 主菜单
	 */
	public void showMenu() {
		while(1==1) {
			System.out.println("输入0退出,1增加部门,2删除部门,3修改部门,4显示所有部门");
			Scanner sc=new Scanner(System.in);
			int n=sc.nextInt();
			switch (n) {
			case 0:
				System.out.println("成功退出系统");
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
