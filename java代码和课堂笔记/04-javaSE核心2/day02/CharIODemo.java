package javase2.day02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/** 字符数据的IO处理 */
public class CharIODemo {
  public static void main(String[] args)
    throws IOException {
    String file = "text.txt";
    //OSW 类是功能扩展, 将基本的byte扩展, 扩展字符数据读取
    OutputStreamWriter out = 
      new OutputStreamWriter(
          new FileOutputStream(file), "utf-8"); 
    //out.write(int) 将int的低16位(char)按照"utf-8"编码, 
    //将编码的结果byte序列, 写到底层的文件流中
    out.write('A');
    out.write(66);
    out.write('中');
    out.write("国北京达内");//将字符串编码utf-8写出到文件中
    out.close();
    IOUtils.print(file);
  }
}
