package javase2.day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/** 常见文本文件写出 代码, 使用过滤器扩展出 println()方法 */
public class TextFileWriterDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "demo.txt"; 
    PrintWriter out = new PrintWriter(
        new OutputStreamWriter(
            new BufferedOutputStream(
                new FileOutputStream(file)),"UTF-8"));
    out.println("HI");
    out.println("  你有莫有呀!");
    out.println("啊哈");
    out.close();
    IOUtils.print(file);
  }
}




