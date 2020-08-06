package day12jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EmpJdbc {
	
	public static void main(String[] args) throws SQLException {
		//����url user password
		String url="jdbc:mysql://localhost:3306/work";
		String user="root";
		String password="root";
		
		//2 ����һ������
		//Connection-�ӿ� java.sql.DriverManage->��
		
		Connection con=DriverManager.getConnection(url, user, password);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("������Ҫ�޸�Ա������Ϣ");
		   String empName=sc.next();
			int deptNo=sc.nextInt();
			double salary=sc.nextDouble();
		int empNo=sc.nextInt();
	 
		String sql="updapt emp set empName=?,deptName=?,salary=? where empNo=?";
		//String sql="insert into emp values(null,?,?,?)";
		//String sql="delete from emp where empNo=?";
		//String sql="insert into dept values(null,'���в�','���԰����')";

		//ʹ��con����õ�һ��ִ��sql������
		PreparedStatement psmt=con.prepareStatement(sql);
		
		psmt.setString(1, empName);
		psmt.setInt(2, deptNo);
		psmt.setDouble(3, salary);
		psmt.setInt(4, empNo);
		
		
		
		
		//ִ����ɾ��  ��������
		int n=psmt.executeUpdate();
		if(n>0) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
		
		//�ͷ���Դ
		if(null!=psmt) {
			psmt.close();
		}
		if(null!=con) {
			con.close();
		}
	}
}
