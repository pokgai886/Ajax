package day12jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class testJdbc {
	
	public static void main(String[] args) throws SQLException {
		//����url user password
		String url="jdbc:mysql://localhost:3306/work";
		String user="root";
		String password="root";
		
		//2 ����һ������
		//Connection-�ӿ� java.sql.DriverManage->��
		
		Connection con=DriverManager.getConnection(url, user, password);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("�����벿������,��ע��Ϣ");
		String deptName=sc.next();
		String deptDesc=sc.next();
		String sql="insert into dept values(null,?,?)";
		//String sql="insert into dept values(null,'���в�','���԰����')";

		//ʹ��con����õ�һ��ִ��sql������
		PreparedStatement psmt=con.prepareStatement(sql);
		psmt.setString(1, deptName);
		psmt.setString(2, deptDesc);
		
		
		
		//ִ����ɾ��  ��������
		int n=psmt.executeUpdate();
		if(n>0) {
			System.out.println("���ӳɹ�");
		}else {
			System.out.println("����ʧ��");
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
