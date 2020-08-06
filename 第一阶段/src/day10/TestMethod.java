package day10;

public class TestMethod {

	@SuppressWarnings("finally")
	public static int method() {
		int i=1;
		try {
			i++;
			return i;
		}catch(Exception e) {
			
		}
		finally {
			return 0;
		}
		
	}
	public static int method1() {
		int i=1;
		try {
			i++;
			return i;
		}catch(Exception e) {
			
		}
		finally {
			i++;
			
		}
		return 3;
	}
	public static void main(String[] args) {
		System.out.println(method());
		System.out.println(method1());
	}

}
