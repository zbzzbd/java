package javase2.day03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
 
/** ���Խ�Byte���鰴�����ķ�ʽ���з���, ÿ�ζ�ȡһ��byte */
public class ByteArrayIODemo {
  public static void main(String[] args) 
    throws IOException{
    //�������ݴ���ķ�ʽ, ÿ��ֻ����һ��byte
    //�����Դ����ļ�, Ҳ����byte[] ��
    byte[] ary = {65,66,1,(byte)0xd6,3};
    InputStream in = new ByteArrayInputStream(ary);
    int b = in.read();
    System.out.println(b);//65
    b = in.read();
    System.out.println(b);//66
    b = in.read();
    System.out.println(b);//1
    b = in.read();
    System.out.println(b);//0xd6
    b = in.read();
    System.out.println(b);//3
    b = in.read();
    System.out.println(b);//-1
    in.close();

    //Ĭ��ByteArrayOutputStream ����һ��byte[32] ��Ϊ���
    //������, ������˾ͽ�������.
    ByteArrayOutputStream out = 
      new ByteArrayOutputStream(32);
    out.write(65);
    out.write(0xf);
    out.write(0xd6);
    out.write(0xd0);
    out.close();
    byte[] buf = out.toByteArray();
    IOUtils.print(buf);
    System.out.println(Arrays.toString(buf)); 
  }
}




