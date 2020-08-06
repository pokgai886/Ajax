package day18con.etc.entity;

public class User {
	private int uid;
	private String uname;
	private String upwd;
	private String usex;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(int uid, String uname, String upwd, String usex) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
	}
	
	public User(String uname, String upwd) {
		super();
		this.uname = uname;
		this.upwd = upwd;
	}
	
	public User(String uname, String upwd, String usex) {
		super();
		this.uname = uname;
		this.upwd = upwd;
		this.usex = usex;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", usex=" + usex + "]";
	}
	
}
