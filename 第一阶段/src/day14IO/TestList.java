package day14IO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("c:\\windows");
		//file.list()���ص����ַ�������
//		String[] files=file.list();
//		for (String string : files) {
//			System.out.println(string);
//		}
		File[] files1=file.listFiles();
		for (File f : files1) {
			System.out.println("�ļ���[Ŀ¼��]:"+f.getName()+",����"+f.length()+",�Ƿ����ļ�:"+f.isFile()+",�ϴ��޸�ʱ��:"+new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(new Date(f.lastModified())));
		}
	}

}
