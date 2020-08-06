package day05;

public class Animal {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Animal(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Animal [name=" + name + "]";
	}

	public void show(String something) {
		System.out.println(name+"在吃东西"+something);
		System.out.println(name+"在吃"+something);
	
	}
}
