package day15�߳�;

public class BoilWater extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("��ʼ��ˮ");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ˮ�պ���");
	}
}
