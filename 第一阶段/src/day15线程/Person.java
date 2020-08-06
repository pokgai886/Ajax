package day15线程;

public class Person {
	private String name;
	private String sex;
	//得到当前对象信息
	public void showPerson() {
		System.out.println(name+"->"+sex);
	}
	//设置修改个人信息
	public void setPerson(String name,String sex) {
		this.name=name;
		//修改姓名和性别之间睡眠
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sex=sex;
	}
	
}	
