package day05;

public class boy {
	
	private String name;
	private String nicName;
	private String faceScore;
	private int age;
	
	
	
	
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age<0) {
			System.out.println("年龄输入有误,请重新输入");
		}
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNicName() {
		return nicName;
	}
	public void setNicName(String nicName) {
		this.nicName = nicName;
	}
	public String getFaceScore() {
		return faceScore;
	}
	public void setFaceScore(String faceScore) {
		this.faceScore = faceScore;
	}
	public void helpOthers() {
		
		System.out.println(name+"是一个好人,有求必应");
		System.out.println(nicName+"是一个好人,有求必应");
			
	}
    public void helpOthers(String other) {
		
		System.out.println(name+"是一个好人,他喜欢帮助"+other);
	}
 public void age(int age) {
		
		System.out.println(age);
	}
}
