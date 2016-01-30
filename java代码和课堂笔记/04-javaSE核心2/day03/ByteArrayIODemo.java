package javase2.day03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
 
/** 可以将Byte数组按照流的方式进行访问, 每次读取一个byte */
public class ByteArrayIODemo {
  public static void main(String[] args) 
    throws IOException{
    //流是数据处理的方式, 每次只处理一个byte
    //流可以处理文件, 也处理byte[] 等
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

    //默认ByteArrayOutputStream 创建一个byte[32] 作为输出
    //缓冲区, 如果满了就进行扩容.
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




