package javase2.day02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

/** ��������IO */
public class DataIODemo {
  public static void main(String[] args) 
    throws IOException{
    String file = "data.dat";
    OutputStream out = new FileOutputStream(file);
    BufferedOutputStream bos=
      new BufferedOutputStream(out);
    DataOutputStream dos = new DataOutputStream(bos);
    //DataOutputStream �� �Ի���Byte�����out�Ĺ�����չ
    //��չ���������͵�IO����: wrtieInt() ��Щ�����ĵײ�
    //��out.write(int)ʵ�ֵ�.
    dos.writeInt(-3);
    dos.writeLong(-4L);
    dos.writeDouble(4);
    dos.writeBoolean(true);
    dos.flush();//�㵹������
    dos.close();//Ĭ�����㵹��������
    IOUtils.print(file);
    //�������͵Ķ�ȡ����,�������Ͷ�ȡ�����ײ���in.read()
    InputStream in = new FileInputStream(file);
    BufferedInputStream bis=new BufferedInputStream(in);
    DataInputStream dis = new DataInputStream(bis);
    int i = dis.readInt();
    long l = dis.readLong();
    double d = dis.readDouble();
    boolean b = dis.readBoolean();
    System.out.println(i+","+l+","+d+","+b);
    dis.close();
  }
}





