package javase2.day02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/** �ı��ļ��Ķ�ȡ  */
public class CharReaderDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "demo.txt"; 
    InputStreamReader in = 
      new InputStreamReader(
          new FileInputStream(file), "UTF-8");
    //read()�ӵײ���ļ����ж�ȡbyte����, ����"utf-8" ����
    //Ϊ�ַ�, ��䵽int����ĵ�16λ, ��λ����16��0, 
    //���������Χ: 0000 0000 ~ 0000 ffff, ����-1��ʾ��ȡ����! 
    int ch;
    while((ch=in.read())!=-1){
      System.out.print(
          Integer.toHexString(ch)+"("+(char)ch+")");
    }
    in.close();
  }

}
