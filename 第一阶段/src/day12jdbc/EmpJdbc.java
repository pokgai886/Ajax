package day12jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpJdbc {
	
	public static void main(String[] args) throws SQLException {
		//创建url user password
		String url="jdbc:mysql://localhost:3306/work";
		String user="root";
		String password="root";
		
		//2 创建一个连接
		//Connection-接口 java.sql.DriverManage->类
		
		Connection con=DriverManager.getConnection(url, user, password);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入要修改员工的信息");
		   String empName=sc.next();
			int deptNo=sc.nextInt();
			double salary=sc.nextDouble();
		int empNo=sc.nextInt();
	 
		String sql="updapt emp set empName=?,deptName=?,salary=? where empNo=?";
		//String sql="insert into emp values(null,?,?,?)";
		//String sql="delete from emp where empNo=?";
		//String sql="insert into dept values(null,'初中部','软件园二期')";

		//使用con对象得到一个执行sql语句对象
		PreparedStatement psmt=con.prepareStatement(sql);
		
		psmt.setString(1, empName);
		psmt.setInt(2, deptNo);
		psmt.setDouble(3, salary);
		psmt.setInt(4, empNo);
		
		
		
		
		//执行增删改  并处理结果
		int n=psmt.executeUpdate();
		if(n>0) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		
		//释放资源
		if(null!=psmt) {
			psmt.close();
		}
		if(null!=con) {
			con.close();
		}
	}
}
