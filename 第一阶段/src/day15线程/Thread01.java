package day15线程;

public class Thread01 extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;1==1;) {
			System.out.println("你好啊,我会一直循环~~~~");
		}
	}
}
