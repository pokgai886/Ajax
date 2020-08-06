package day12jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class testJdbcquery {
	
	public static void main(String[] args) throws SQLException {
		//����url user password
		String url="jdbc:mysql://localhost:3306/work";
		String user="root";
		String password="root";
		
		//2 ����һ������
		//Connection-�ӿ� java.sql.DriverManage->��
		
		Connection con=DriverManager.getConnection(url, user, password);
		
//		Scanner sc=new Scanner(System.in);
//		System.out.println("�����벿������,��ע��Ϣ");
//		String deptName=sc.next();
//		String deptDesc=sc.next();
		//String sql="insert into dept values(null,?,?)";
		//String sql="insert into dept values(null,'���в�','���԰����')";
		String sql="select emp.empName,dept.deptName from emp inner join dept on emp.deptNo=dept.deptNo";
		
		
		//ʹ��con����õ�һ��ִ��sql������
		PreparedStatement psmt=con.prepareStatement(sql);
		ResultSet rs=psmt.executeQuery();
		while(rs.next()) {
			//String str=rs.getInt(1)+","+rs.getString(2)+","+rs.getInt(3)+","+rs.getDouble(4)+","+rs.getInt(5)+","+rs.getString(6)+","+rs.getString(7);
			String str=rs.getString("empName")+","+rs.getString("deptName");
			System.out.println(str);
		}
		
		
		
		//ִ����ɾ��  ��������
//		int n=psmt.executeUpdate();
//		if(n>0) {
//			System.out.println("���ӳɹ�");
//		}else {
//			System.out.println("����ʧ��");
//		}
		
		//�ͷ���Դ
		if(null!=rs) {
			psmt.close();
		}
		if(null!=con) {
			con.close();
		}
	}
}
