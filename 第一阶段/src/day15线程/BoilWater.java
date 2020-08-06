package day15线程;

public class BoilWater extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始烧水");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("水烧好了");
	}
}
