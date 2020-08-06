package day14IO;

import java.io.File;
import java.io.IOException;

public class TestFile {
	public static void main(String[] args) {
		File file=new File("e:\\aaaaa\\a.txt");
		System.out.println(file.exists());
		if(!file.exists()) {
			try {
				boolean flag=file.createNewFile();
				System.out.println(flag);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File file2=new File("e:\\aaaaa");
			if(!file2.exists()) {
				file2.mkdirs();
				System.out.println("创建目录成功");
			}else {
				System.out.println("创建目录失败");

			}
		}
	}
}
