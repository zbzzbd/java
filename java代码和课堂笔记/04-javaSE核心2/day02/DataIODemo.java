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

/** 基本类型IO */
public class DataIODemo {
  public static void main(String[] args) 
    throws IOException{
    String file = "data.dat";
    OutputStream out = new FileOutputStream(file);
    BufferedOutputStream bos=
      new BufferedOutputStream(out);
    DataOutputStream dos = new DataOutputStream(bos);
    //DataOutputStream 是 对基本Byte输出流out的功能扩展
    //扩展出基本类型的IO方法: wrtieInt() 这些方法的底层
    //是out.write(int)实现的.
    dos.writeInt(-3);
    dos.writeLong(-4L);
    dos.writeDouble(4);
    dos.writeBoolean(true);
    dos.flush();//倾倒缓冲区
    dos.close();//默认是倾倒缓冲区的
    IOUtils.print(file);
    //基本类型的读取操作,基本类型读取方法底层是in.read()
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





