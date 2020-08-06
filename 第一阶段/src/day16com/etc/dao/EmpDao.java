package day16com.etc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import day13com.etc.entity.Emp;

/**
 * 数据库访问操作
 * @author Administrator
 *
 */
public class EmpDao {
	String url="jdbc:mysql://localhost:3306/work?characterEncoding=utf-8";
	String user="root";
	String password="root";
	Connection con=null;
	PreparedStatement p=null; 
	ResultSet rs=null;
	Emp emp=null;
	
	//查询
	public List<Emp> queryAll() {
		List<Emp> list=new ArrayList<Emp>();
		String sql="select * from emp";
		try {
			con=DriverManager.getConnection(url, user, password);
			p=con.prepareStatement(sql);
			rs=p.executeQuery();
			while(rs.next()) {
				int empNo=rs.getInt(1);
				String empName=rs.getString(2);
				int deptNo=rs.getInt(3);
				double salary=rs.getDouble(4);
				emp=new Emp(empNo,empName,deptNo,salary);
				list.add(emp);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//增加
	public boolean addEmp(Emp emp) {
	String sql="insert into emp values(null,?,?,?)";
	int n=0;
	
	try {
		con=DriverManager.getConnection(url, user, password);
		p=con.prepareStatement(sql);
		p.setString(1, emp.getEmpName());
		p.setInt(2, emp.getDeptNo());
		p.setDouble(3, emp.getSalary());
		n=p.executeUpdate();
		
		
		
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return n>0;	
 }

}
