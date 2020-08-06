package day11dept;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class hapdept {
	private HashMap<Integer,Dept> depts=new HashMap<Integer,Dept>();
	/**
	 * 增加部门
	 */
	public void addDept(Dept dept) {
		depts.put(dept.getDeptNo(), dept);
		System.out.println("增加成功");
	}
	public void inputDept() {
		System.out.println("请输入部门编号,部门名称,部门描述");
		Scanner sc=new Scanner(System.in);
		int deptNo=sc.nextInt();
		String deptName=sc.next();
		String deptDesc=sc.next();
		Dept dept=new Dept(deptNo,deptName,deptDesc);
		addDept(dept);
	}
	//显示部门
	public void showDept(){
		Iterator<Integer> itor=depts.keySet().iterator();
		while(itor.hasNext()) {
			Integer key=itor.next();
			System.out.println(depts.get(key).toString());
		}
	}
	
}
