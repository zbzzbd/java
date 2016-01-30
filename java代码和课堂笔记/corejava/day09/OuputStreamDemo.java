package day09;
import java.io.*;
public class OuputStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			OutputStream out =
				new FileOutputStream("demo.txt");
			out.write(0x41);//A 按byte写出
			out.write(0xd6);//按byte写出
			out.write(0xd0);//按byte写出，两个byte组成一个汉字中
			out.write("面朝大海".getBytes("GBK"));//字符串的byte数组
			out.write("ABC欢迎".getBytes("GBK"), 3, 4);//byte数组从下标为3开始，写出4个byte的数据
			out.flush();//刷缓存，强制写出
			out.close();//关闭流，包括flush动作
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
