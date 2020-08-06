package day15线程;

import java.util.Random;

public class TicketRunnable implements Runnable {
	
	//卖100张票
	private int ticketCount=100;
	//定义一个方法执行卖票的操作
	protected synchronized void saleTicket() {
		if(ticketCount>0) {
			//顺便一下Thread的一些方法
			Thread th=Thread.currentThread();//当前执行的线程对象
			System.out.println(th.getId()+","+th.getName()+"正在卖第"+ticketCount--+"张票");
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
