package day15线程;

public class TestThread extends Thread {
	private long time;

	public TestThread(long time) {
		super();
		this.time = time;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread th=Thread.currentThread();
		System.out.println(th.getName()+"正在执行中~~~");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(th.getName()+"已经执行完成....");
	}
	
	
}
