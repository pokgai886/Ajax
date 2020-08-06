package com.etc.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import day18con.etc.dao.UserDao;
import day18con.etc.entity.User;
import day18con.etc.util.DBUtil;

public class Userdaoservice {
//	String url="jdbc:mysql://localhost:3306/work?characterEncoding=utf-8";
//	String user="root";
//	String password="root";
//	Connection con=null;
//	PreparedStatement p=null; 
//	ResultSet rs=null;
	
	//查询
//	public List<User> queryALL(){
//		List<User> ur=new ArrayList<>();
//		try {
//			con=DriverManager.getConnection(url, user, password);
//			String sql="select uname,upwd from user";
//			p=con.prepareStatement(sql);
//			p.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//		
//	}
	UserDao dao=new UserDao();
	public User login001(String uname,String pwd) {
		return dao.login(uname, pwd);
	}
	/**
	 * 注册
	 */
	public int registerUser(User user) {
		List<User> lists=queryAll();
		for (User u : lists) {
			if(u.getUname().equals(user.getUname())) {
				return 2;
			}
			else if(u.getUname().equals("00")) {
				return 1;
			}
			
		}
		
		return dao.registerUser(user)==true?0:1;
				
	}
	/**
	 * 查询
	 */
	public User login(String uname,String upwd) {
		CachedRowSet crs=DBUtil.execQuery("select * from user where uname=? and upwd=?", uname,upwd);
		User us=null;
		try {
			while(crs.next()) {
				int id=crs.getInt("uid");
				String name=crs.getString("uname");
				String pwd=crs.getString("upwd");
				String sex=crs.getString("usex");
				us=new User(id,name,pwd,sex);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return us;
	}
	/**
	 * 修改
	 */
	public boolean updateUser(User user) {
		return dao.updateUser(user);
	} 
	/**
	 * 查询全部
	 */
	public List<User> queryAll() {
		return dao.queryAll();
	}
	/**
	 * 模糊查询
	 */
	public List<User> queryLikeAll(String name) {
		
		return dao.queryLikeAll(name);
	}
	/**
	 * 通过id查找
	 */
	public  User queryById(int id){
		
		return dao.queryById(id);
	}
	/**
	 * 删除
	 */
	public boolean deleUser(int uid) {
		return dao.deleUser(uid);
	}
	
}	
