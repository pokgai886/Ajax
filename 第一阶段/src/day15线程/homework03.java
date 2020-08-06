package day15线程;

public class homework03 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(;1==1;) {
				System.out.println("每过9秒");
				Thread.sleep(9000);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
