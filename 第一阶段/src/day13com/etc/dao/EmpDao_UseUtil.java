package day13com.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;

import day13com.etc.entity.Emp;
import day13com.etc.util.DBUtil;

public class EmpDao_UseUtil {
/**
 * ����Ա��
 */
	public boolean addEmp(Emp emp) {
		if(null!=emp) {
			String sql="insert into emp values(null,?,?,?)";
			return DBUtil.execUpdate(sql, emp.getEmpName(),emp.getDeptNo(),emp.getSalary());

		}
		return false;
	}
	/**
	 * ɾ��Ա��
	 * @param empNo
	 * @return
	 */
	public boolean deleEmp(int empNo) {
	if(empNo>0) {
		String sql="delete from emp where empNo=?";
		return DBUtil.execUpdate(sql, empNo);
	}
		return false;
	}
	/**
	 * �޸�Ա��
	 */
	public boolean updapt(Emp emp) {
		if(null!=emp) {
			String sql="update emp set empName=?,deptNo=?,salary=? where empNo=?";
			return DBUtil.execUpdate(sql, emp.getEmpName(),emp.getDeptNo(),emp.getSalary(),emp.getEmpNo());
		}
		return false;
		
	}
	/**
	 * ��ѯԱ��
	 */
	public List<Emp> queryAll(){
		List<Emp> list=new ArrayList<>();
		String sql="select * from emp";
		CachedRowSet crs=DBUtil.execQuery(sql);
		try {
			while(crs.next()) {
				int empNo=crs.getInt("empNo");
				String empName=crs.getString("empName");
				int deptNo=crs.getInt("deptNo");
				double salary=crs.getDouble("salary");
				//ʵ����Emp����
				Emp emp=new Emp(empNo,empName,deptNo,salary);
				//��ӵ�������
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	/**
	 * ���ղ��ű�Ų�ѯԱ��
	 */
	public List<Emp> queryAll1(int deptNo){
		List<Emp> list=new ArrayList<>();
		String sql="select * from emp where deptNo=?";
		CachedRowSet crs=DBUtil.execQuery(sql,deptNo);
		try {
			while(crs.next()) {
				int empNo=crs.getInt("empNo");
				String empName=crs.getString("empName");
				int deptNo1=crs.getInt("deptNo");
				double salary=crs.getDouble("salary");
				//ʵ����Emp����
				Emp emp=new Emp(empNo,empName,deptNo1,salary);
				//��ӵ�������
				list.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
}
