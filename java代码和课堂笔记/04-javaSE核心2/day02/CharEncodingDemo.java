package javase2.day02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** 字符编码方案 
 * 将Java内部的char(16位unicode 整数)编码序列化为byte序列
 * 叫编码方案
 * 如果把文本(char序列)写入到文件, 就必须编码为byte, 文件
 * 只能存储byte序列!
 **/
public class CharEncodingDemo {
  public static void main(String[] args) 
    throws IOException {
    String str = "ABCD中国北京";
    System.out.println(str); 
    System.out.println("UTF-16BE 编码方案:");
    String file = "utf16be.txt";
    byte[] buf = str.getBytes("UTF-16BE");
    OutputStream out = new FileOutputStream(file);
    out.write(buf);
    out.close();
    IOUtils.print(file);
    
    System.out.println("UTF-8编码方案:"); 
    file = "utf8.txt";
    buf = str.getBytes("UTF-8");
    out = new FileOutputStream(file);
    out.write(buf);
    out.close();
    IOUtils.print(file);
    
    System.out.println("GBK编码方案:"); 
    file = "gbk.txt";
    buf = str.getBytes("GBK");
    out = new FileOutputStream(file);
    out.write(buf);
    out.close();
    IOUtils.print(file);
    
    System.out.println("iso8859-1编码方案(只支持英文!):"); 
    file = "iso8859.txt";
    buf = str.getBytes("iso8859-1");
    out = new FileOutputStream(file);
    out.write(buf);
    out.close();
    IOUtils.print(file);
    
    System.out.println("文本文件的byte序列的解码:");
    file = "gbk.txt";
    InputStream in = new FileInputStream(file);
    //in.available() 返回流中可以读取的byte数据个数, 
    //经常是文件的长度!
    byte[] gbk = new byte[in.available()];
    in.read(gbk);//读取文件的全部内容
    in.close();
    //new String(byte,encoding)可以将byte序列解码为字符串
    String s = new String(gbk, "gbk");
    System.out.println(s); 
    String ss = new String(gbk, "utf-8");//乱码现象
    System.out.println(ss); 
    
    System.out.println("系统默认编码:" +
        System.getProperty("file.encoding"));//GBK
  }
}


