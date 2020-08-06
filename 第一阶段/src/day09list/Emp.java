package day09list;

public class Emp {
	private int empNo;
	private String empName;
	private String deptName;
	private double salary;
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Emp(int empNo, String empName, String deptName, double salary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.deptName = deptName;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", deptName=" + deptName + ", salary=" + salary + "]";
	}
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	
}	
