package day15线程;

public class homework02 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for(;1==1;) {
				System.out.println("每过7秒");
				Thread.sleep(7000);
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
