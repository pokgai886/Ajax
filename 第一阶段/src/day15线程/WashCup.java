package day15�߳�;

public class WashCup extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Ȼ��ʼϴ����");
		try {
			for(int i=1;i<5;i++) {
				Thread.sleep(5000);
				System.out.println("��"+i+"������ϴ����");

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
