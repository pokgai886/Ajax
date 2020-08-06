package day11dept;

public class Dept {
	private int deptNo;
	private String deptName;
	private String deptDesc;
	
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptDesc() {
		return deptDesc;
	}
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}
	
	@Override
	public String toString() {
		return "Dept [deptNo=" + deptNo + ", deptName=" + deptName + ", deptDesc=" + deptDesc + "]";
	}
	
	
	public Dept() {
		// TODO Auto-generated constructor stub
	}
	
	public Dept(int deptNo, String deptName, String deptDesc) {
		super();
		this.deptNo = deptNo;
		this.deptName = deptName;
		this.deptDesc = deptDesc;
	}
	

}
