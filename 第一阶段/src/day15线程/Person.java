package day15�߳�;

public class Person {
	private String name;
	private String sex;
	//�õ���ǰ������Ϣ
	public void showPerson() {
		System.out.println(name+"->"+sex);
	}
	//�����޸ĸ�����Ϣ
	public void setPerson(String name,String sex) {
		this.name=name;
		//�޸��������Ա�֮��˯��
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.sex=sex;
	}
	
}	
