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
			out.write(0x41);//A ��byteд��
			out.write(0xd6);//��byteд��
			out.write(0xd0);//��byteд��������byte���һ��������
			out.write("�泯��".getBytes("GBK"));//�ַ�����byte����
			out.write("ABC��ӭ".getBytes("GBK"), 3, 4);//byte������±�Ϊ3��ʼ��д��4��byte������
			out.flush();//ˢ���棬ǿ��д��
			out.close();//�ر���������flush����
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
