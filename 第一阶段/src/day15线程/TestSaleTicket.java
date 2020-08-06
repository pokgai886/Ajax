package day15Ïß³Ì;

public class TestSaleTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketRunnable tr=new TicketRunnable();
		Thread th1=new Thread(tr);
		th1.start();
		new Thread(tr).start();
		new Thread(tr).start();
		new Thread(tr).start();
	}

}
