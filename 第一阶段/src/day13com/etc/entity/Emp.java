package day13com.etc.entity;
/**
 *  µÃÂ¿‡
 * @author Administrator
 *
 */
public class Emp {
	private int empNo;
	private String empName;
	private int deptNo;
	private  double salary;
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
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Emp(int empNo, String empName, int deptNo, double salary) {
		super();
		this.empNo = empNo;
		this.empName = empName;
		this.deptNo = deptNo;
		this.salary = salary;
	}
	
	public Emp(String empName, int deptNo, double salary) {
		super();
		this.empName = empName;
		this.deptNo = deptNo;
		this.salary = salary;
	}
	public Emp(String empName, int deptNo, double salary,int empNo) {
		super();
		this.empName = empName;
		this.deptNo = deptNo;
		this.salary = salary;
		this.empNo=empNo;
	}
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Emp [empNo=" + empNo + ", empName=" + empName + ", deptNo=" + deptNo + ", salary=" + salary + "]";
	}
	
}
