package javase2.day02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/** �ַ����ݵ�IO���� */
public class CharIODemo {
  public static void main(String[] args)
    throws IOException {
    String file = "text.txt";
    //OSW ���ǹ�����չ, ��������byte��չ, ��չ�ַ����ݶ�ȡ
    OutputStreamWriter out = 
      new OutputStreamWriter(
          new FileOutputStream(file), "utf-8"); 
    //out.write(int) ��int�ĵ�16λ(char)����"utf-8"����, 
    //������Ľ��byte����, д���ײ���ļ�����
    out.write('A');
    out.write(66);
    out.write('��');
    out.write("����������");//���ַ�������utf-8д�����ļ���
    out.close();
    IOUtils.print(file);
  }
}
