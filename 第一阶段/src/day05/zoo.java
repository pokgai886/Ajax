package day05;

public class zoo {
	private Animal[] animals=new Animal[2];
	
	public void setAnimals() {
		Animal animal01=new Animal("�ϻ�");
		Animal animal02=new Animal("ʨ��");
		animals[0]=animal01;
		animals[1]=animal02;
	}
	public void show() {
		animals[0].show("����");
		animals[1].show("�Ǻ�");
	}
}
