package day15Ïß³Ì;

public class testTestThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(1==1) {
		Thread th01=new TestThread(5000);
		th01.start();
		try {
			th01.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread th02=new TestThread(7000);
		th02.start();
		try {
			th02.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread th03=new TestThread(9000);
		th03.start();
		try {
			th03.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

}
