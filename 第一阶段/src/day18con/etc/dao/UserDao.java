package day18con.etc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import day18con.etc.entity.User;
import day18con.etc.util.DBUtil;

public class UserDao {
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
	/**
	 * 注册
	 */
	public boolean registerUser(User user) {
		return DBUtil.execUpdate("insert into user values(null,?,?,?)", user.getUname(),user.getUpwd(),user.getUsex());
		
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
		return DBUtil.execUpdate("update user set upwd=?,usex=? where uname=?", user.getUpwd(),user.getUsex(),user.getUname());
		
	} 
	/**
	 * 查询全部
	 */
	public List<User> queryAll() {
		List<User> list=new ArrayList<>();
		CachedRowSet crs=DBUtil.execQuery("select * from user");
		User user=null;
		try {
			while(crs.next()) {
				int id=crs.getInt("uid");
				String name=crs.getString("uname");
				String pwd=crs.getString("upwd");
				String sex=crs.getString("usex");
				user=new User(id,name,pwd,sex);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 模糊查询
	 */
	public List<User> queryLikeAll(String name) {
		List<User> list=new ArrayList<>();
		CachedRowSet crs=DBUtil.execQuery("select * from user where uname like ?","%"+name+"%");
		User user=null;
		try {
			while(crs.next()) {
				int id=crs.getInt("uid");
				String name01=crs.getString("uname");
				String pwd=crs.getString("upwd");
				String sex=crs.getString("usex");
				user=new User(id,name01,pwd,sex);
				list.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 通过id查找
	 */
	public static User queryById(int id){
		String sql = "select * from user where uid = ?";
		CachedRowSet crs = DBUtil.execQuery(sql, id);
		User user = null;
		try {
			while (crs.next()) {
				int uid = crs.getInt("uid");
				String uname = crs.getString("uname");
				String upwd = crs.getString("upwd");
				String usex = crs.getString("usex");
				user = new User(uid, uname, upwd, usex);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	/**
	 * 删除
	 */
	public boolean deleUser(int uid) {
		return DBUtil.execUpdate("delete from user where uid=?", uid);
		
	}
	
}	
