package day08ื๗าต;

import java.util.Random;

public class computer extends player {
	public computer(String name,int score) {
		super(name,score);
	}
	public computer() {
		
	}
	@Override
	public int showfist() {
		// TODO Auto-generated method stub
		Random random=new Random();
		return random.nextInt(3)+1;
	}

}
