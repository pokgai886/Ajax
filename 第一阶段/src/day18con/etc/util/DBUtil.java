package day18con.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * ���ݿ�ͨ�ù���.��������
 * @author Administrator
 *
 */
public class DBUtil {
	public static final String url="jdbc:mysql://localhost:3306/work?characterEncoding=utf-8";
	public static final String user="root";
	public static final String password="root";
	/**
	 * ����һ�����Ӷ���
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * ��ɾ��
	 */
	public static boolean execUpdate(String sql,Object... params) {
		Connection con=null;
		PreparedStatement p=null;
		int n=0;
		try {
			con=getConn();
			//ͨ��connection����õ�preparestatement
			p=con.prepareStatement(sql);
			//��?��ֵ
			setPreparedStatement(p,params);
			//ִ��sql
			n=p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			closeAll(null,p,con);
		}
		return n>0;
	}
	public static void setPreparedStatement(PreparedStatement p,Object... params) {
		if(null!=params && null!=p) {
			for(int i=0;i<params.length;i++) {
				try {
					p.setObject(i+1, params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * ��ѯԱ��
	 */
	public static CachedRowSet execQuery(String sql,Object... params) {
		Connection con=null;
		PreparedStatement p=null;
		ResultSet rs=null;
		CachedRowSet crs=null;
		
		try {
			crs=new CachedRowSetImpl();
			con=getConn();
			//ͨ��connection����õ�preparestatement
			p=con.prepareStatement(sql);
			//��?��ֵ
			setPreparedStatement(p,params);
			//ִ��sql
			rs=p.executeQuery();
			//ResultSet��CachedRowSet֮���ת��
			crs.populate(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ͷ���Դ
			closeAll(rs,p,con);
		}
		//���ص���һ��CachedRowSet
		return crs;
	}
	
	/**
	 * �ͷ���Դ
	 */
	public static void closeAll(ResultSet rs,PreparedStatement p,Connection con) {
		try {
			if(null!=rs) {
				rs.close();
			}
			if(null!=p) {
				p.close();
			}
			if(null!=con) {
				con.close();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
