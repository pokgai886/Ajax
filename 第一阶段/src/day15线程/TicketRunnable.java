package day15�߳�;

import java.util.Random;

public class TicketRunnable implements Runnable {
	
	//��100��Ʊ
	private int ticketCount=100;
	//����һ������ִ����Ʊ�Ĳ���
	protected synchronized void saleTicket() {
		if(ticketCount>0) {
			//˳��һ��Thread��һЩ����
			Thread th=Thread.currentThread();//��ǰִ�е��̶߳���
			System.out.println(th.getId()+","+th.getName()+"��������"+ticketCount--+"��Ʊ");
			try {
				Thread.sleep(new Random().nextInt(3));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(ticketCount>0) {
			saleTicket();
		}
	}

}
