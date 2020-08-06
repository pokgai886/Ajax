package day18con.etc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

/**
 * 数据库通用工具.返回连接
 * @author Administrator
 *
 */
public class DBUtil {
	public static final String url="jdbc:mysql://localhost:3306/work?characterEncoding=utf-8";
	public static final String user="root";
	public static final String password="root";
	/**
	 * 返回一个连接对象
	 * @return
	 * @throws SQLException 
	 */
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
	
	/**
	 * 增删改
	 */
	public static boolean execUpdate(String sql,Object... params) {
		Connection con=null;
		PreparedStatement p=null;
		int n=0;
		try {
			con=getConn();
			//通过connection对象得到preparestatement
			p=con.prepareStatement(sql);
			//给?赋值
			setPreparedStatement(p,params);
			//执行sql
			n=p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//释放资源
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
	 * 查询员工
	 */
	public static CachedRowSet execQuery(String sql,Object... params) {
		Connection con=null;
		PreparedStatement p=null;
		ResultSet rs=null;
		CachedRowSet crs=null;
		
		try {
			crs=new CachedRowSetImpl();
			con=getConn();
			//通过connection对象得到preparestatement
			p=con.prepareStatement(sql);
			//给?赋值
			setPreparedStatement(p,params);
			//执行sql
			rs=p.executeQuery();
			//ResultSet与CachedRowSet之间的转换
			crs.populate(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//释放资源
			closeAll(rs,p,con);
		}
		//返回的是一个CachedRowSet
		return crs;
	}
	
	/**
	 * 释放资源
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
