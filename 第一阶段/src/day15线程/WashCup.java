package day15线程;

public class WashCup extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("然后开始洗杯子");
		try {
			for(int i=1;i<5;i++) {
				Thread.sleep(5000);
				System.out.println("第"+i+"个杯子洗好了");

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
