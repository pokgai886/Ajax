package day05;

public class zoo {
	private Animal[] animals=new Animal[2];
	
	public void setAnimals() {
		Animal animal01=new Animal("ÀÏ»¢");
		Animal animal02=new Animal("Ê¨×Ó");
		animals[0]=animal01;
		animals[1]=animal02;
	}
	public void show() {
		animals[0].show("¹þ¹þ");
		animals[1].show("ºÇºÇ");
	}
}
