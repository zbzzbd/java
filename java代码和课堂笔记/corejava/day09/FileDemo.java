package day09;

import java.io.*;
import java.util.Date;

public class FileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// File的默认相对路径，是"java"命令的启动目录(bin)
		// 在Eclipse中是项目所在的文件夹
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
			File f = new File("test");// 项目为根
			// 判断文件夹是否存在，如果不存在，则创建
			if (!f.exists()) {
				f.mkdir();// make directory
			}

			File myfile = new File(f, "test.txt");
			// 在test文件夹下,如果text.txt不存在，则创建
			if (!myfile.exists()) {
				myfile.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//workspace下存放Corejava项目(文件夹)。
		//假设在项目Corejava下有文件夹mp3(和src并列)/listmp3.txt
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
