package day05;

public class Boy1 {
	private String name;
	private int age;
	private String ah;
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAh() {
		return ah;
	}


	public void setAh(String ah) {
		this.ah = ah;
	}

	public void bo() {
		System.out.println("��Һ�,�ҽ�"+name);
	}
	public void bo(int age) {
		System.out.println("�ҽ���"+age+"��.");
	}
	public void bo(String ah) {
		System.out.println("�ҵİ�����"+ah);
	}
	}

