package day14IO;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;
		try {
			fw=new FileWriter("e:\\aaaaa\\info.txt");
			//д���ļ�
			fw.write("��ð�,����FileWriter~~~");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
