package day08��ҵ;

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
			System.out.println("��"+i+"�ֿ�ʼ");
			int pfist=p.showfist();
			String pValue=getFistValue(pfist);
			int cfist=c.showfist();
			String cValue=getFistValue(cfist);
		
		
		
		if(pfist<=3) {
			if(pfist==1&&cfist==2 || pfist==2&&cfist==3|| pfist==3&&cfist==1) {
				//�û�Ӯ
				System.out.println(p.getName()+"��ȭ:"+pValue);
				System.out.println(c.getName()+"��ȭ:"+cValue);
				System.out.println("��ϲ"+p.getName()+"Ӯ��");
				p.setScore(p.getScore()+1);
			}else if(pfist==cfist) {
				System.out.println(p.getName()+"��ȭ:"+pValue);
				System.out.println(c.getName()+"��ȭ:"+cValue);
				System.out.println("ƽ��");
			}else {
				System.out.println(p.getName()+"��ȭ:"+pValue);
				System.out.println(c.getName()+"��ȭ:"+cValue);
				System.out.println("��ֵ���Ӯ");
				c.setScore(c.getScore()+1);
			}
			
		}else {
			System.out.println("�����³�ȭ");
			i--;
			continue;
		}
		}
		showResult();
	}
	public void showResult() {
		System.out.println("-----��ʾ���ս��-----");
		System.out.println(p.getName()+"���ջ�û���"+p.getScore());
		System.out.println(c.getName()+"���ջ�û���"+c.getScore());
		if(p.getScore()> c.getScore()) {
			System.out.println(p.getName()+"�������ʤ��");
		}else if(p.getScore()== c.getScore()) {
			System.out.println("ƽ��");
		}else {
			System.out.println(c.getName()+"�������ʤ��");
		}
	}
	

	private String getFistValue(int fist) {
		// TODO Auto-generated method stub
		String str="";
				switch (fist) {
				case 1:
					str="ʯͷ";
					break;
				case 2:
					str="����";
					break;
				case 3:
					str="��";
					break;
				default:
					break;
				}
		return str;
	}
}
