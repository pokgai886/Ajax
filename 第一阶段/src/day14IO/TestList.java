package day14IO;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file=new File("c:\\windows");
		//file.list()返回的是字符串数组
//		String[] files=file.list();
//		for (String string : files) {
//			System.out.println(string);
//		}
		File[] files1=file.listFiles();
		for (File f : files1) {
			System.out.println("文件名[目录名]:"+f.getName()+",长度"+f.length()+",是否是文件:"+f.isFile()+",上次修改时间:"+new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss").format(new Date(f.lastModified())));
		}
	}

}
