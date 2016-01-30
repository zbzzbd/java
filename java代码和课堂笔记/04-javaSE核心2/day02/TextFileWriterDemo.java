package javase2.day02;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/** �����ı��ļ�д�� ����, ʹ�ù�������չ�� println()���� */
public class TextFileWriterDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "demo.txt"; 
    PrintWriter out = new PrintWriter(
        new OutputStreamWriter(
            new BufferedOutputStream(
                new FileOutputStream(file)),"UTF-8"));
    out.println("HI");
    out.println("  ����Ī��ѽ!");
    out.println("����");
    out.close();
    IOUtils.print(file);
  }
}




