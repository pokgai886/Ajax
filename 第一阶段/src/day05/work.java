package day05;

import java.util.Scanner;

public class work {
	
	
	private String name;
	private String admin;
	private String pwd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		
		this.admin = admin;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public boolean login(String name,String upwd) {
		if(name.equals(admin)&&upwd.equals(upwd)) {
			return true;
		}
		return false;
		
		
	}
	
}
