package day09;

import java.io.*;
import java.util.Date;

public class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// File��Ĭ�����·������"java"���������Ŀ¼(bin)
		// ��Eclipse������Ŀ���ڵ��ļ���
		File src = new File("src");
		System.out.println(src.exists());// true
		System.out.println(src.isDirectory());// true
		System.out.println(src.isFile());// false
		System.out.println(src.canRead());// true
		System.out.println(src.canWrite());// true
		System.out.println(src.length());// 0
		System.out.println(src.lastModified());
		long time = src.lastModified();
		Date d = new Date();
		d.setTime(time);
		System.out.println(d);

		File file = new File("src/day13/day13.txt");
		System.out.println(file.isFile());// true
		System.out.println(file.length());
		System.out.println(file.lastModified());
		d.setTime(file.lastModified());
		System.out.println(d);

		try {
			File f = new File("test");// ��ĿΪ��
			// �ж��ļ����Ƿ���ڣ���������ڣ��򴴽�
			if (!f.exists()) {
				f.mkdir();// make directory
			}

			File myfile = new File(f, "test.txt");
			// ��test�ļ�����,���text.txt�����ڣ��򴴽�
			if (!myfile.exists()) {
				myfile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//workspace�´��Corejava��Ŀ(�ļ���)��
		//��������ĿCorejava�����ļ���mp3(��src����)/listmp3.txt
		File mp3 = new File("mp3/listmp3.txt");
		System.out.println(mp3.getName());
		System.out.println(mp3.getPath());
		System.out.println(mp3.getAbsolutePath());
		if(mp3.exists()){
			mp3.delete();
		}else{
			try {
				mp3.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	

	}

}
