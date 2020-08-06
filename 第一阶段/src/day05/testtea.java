package day05;

public class testtea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		laos ls=new laos();
//		ls.setName("小明");
//		ls.shangke();
//		ls.jies("小红 ");
		
		classroom cr=new classroom();
		
		javateacher jt=new javateacher();
		jt.setName("张清");
		cr.showLesson(jt);
		
		diverteacher dt=new diverteacher();
		dt.setName("警铃小姐姐");
		cr.showLesson(dt);;
		
		oldteacher od=new oldteacher();
		od.setName("老司机");
		cr.showLesson(od);
	}

}
