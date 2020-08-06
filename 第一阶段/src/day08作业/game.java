package day08作业;

public class game {
	private person p;
	private computer c;
	
	public game(person p,computer c) {
		super();
		this.c=c;
		this.p=p;
	}
	
	public void pk() {
		
		for(int i=1;i<6;i++) {
			System.out.println("第"+i+"局开始");
			int pfist=p.showfist();
			String pValue=getFistValue(pfist);
			int cfist=c.showfist();
			String cValue=getFistValue(cfist);
		
		
		
		if(pfist<=3) {
			if(pfist==1&&cfist==2 || pfist==2&&cfist==3|| pfist==3&&cfist==1) {
				//用户赢
				System.out.println(p.getName()+"出拳:"+pValue);
				System.out.println(c.getName()+"出拳:"+cValue);
				System.out.println("恭喜"+p.getName()+"赢了");
				p.setScore(p.getScore()+1);
			}else if(pfist==cfist) {
				System.out.println(p.getName()+"出拳:"+pValue);
				System.out.println(c.getName()+"出拳:"+cValue);
				System.out.println("平局");
			}else {
				System.out.println(p.getName()+"出拳:"+pValue);
				System.out.println(c.getName()+"出拳:"+cValue);
				System.out.println("这局电脑赢");
				c.setScore(c.getScore()+1);
			}
			
		}else {
			System.out.println("请重新出拳");
			i--;
			continue;
		}
		}
		showResult();
	}
	public void showResult() {
		System.out.println("-----显示最终结果-----");
		System.out.println(p.getName()+"最终获得积分"+p.getScore());
		System.out.println(c.getName()+"最终获得积分"+c.getScore());
		if(p.getScore()> c.getScore()) {
			System.out.println(p.getName()+"在五局中胜出");
		}else if(p.getScore()== c.getScore()) {
			System.out.println("平局");
		}else {
			System.out.println(c.getName()+"在五局中胜出");
		}
	}
	

	private String getFistValue(int fist) {
		// TODO Auto-generated method stub
		String str="";
				switch (fist) {
				case 1:
					str="石头";
					break;
				case 2:
					str="剪刀";
					break;
				case 3:
					str="布";
					break;
				default:
					break;
				}
		return str;
	}
}
