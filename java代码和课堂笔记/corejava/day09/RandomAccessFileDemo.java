package day09;
import java.util.*;
import java.io.*;
public class RandomAccessFileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//myfile.txt: 41 42 43 d6 d0
	//             0  1  2  3  4
		try {
			RandomAccessFile raf 
				= new RandomAccessFile("myfile.txt", "rw");
			raf.seek(2);
			int b = raf.read();
			System.out.println(Integer.toHexString(b));//43
			raf.seek(3);
			b = raf.read();
			System.out.println(Integer.toHexString(b));//d6
			System.out.println(Integer.toBinaryString(b));
			long pointer = raf.getFilePointer();
			System.out.println(pointer);//��ӡָ���λ��:4
			
			raf.seek(raf.length());//���ļ�β
			raf.write(0xd6);//׷��д�����ļ�β��ָ��++
			raf.write(0xd0);//����byte���һ�����֣���
			raf.write("���".getBytes("GBK"));
			
			//raf�����е����ݶ��뵽buffer�ֽ�������
			byte[] buffer = new byte[(int)raf.length()];
			raf.seek(0);
			int count = raf.read(buffer);
			System.out.println(Arrays.toString(buffer));
		
			String s = new String(buffer, "gbk");
			System.out.println(s);
			raf.close();
			
			//int i = 15;
			//System.out.println(~15);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
