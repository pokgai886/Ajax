package day05;

public class testtea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		laos ls=new laos();
//		ls.setName("С��");
//		ls.shangke();
//		ls.jies("С�� ");
		
		classroom cr=new classroom();
		
		javateacher jt=new javateacher();
		jt.setName("����");
		cr.showLesson(jt);
		
		diverteacher dt=new diverteacher();
		dt.setName("����С���");
		cr.showLesson(dt);;
		
		oldteacher od=new oldteacher();
		od.setName("��˾��");
		cr.showLesson(od);
	}

}
