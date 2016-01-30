package javase2.day03;

import java.io.BufferedInputStream;
import java.io.BufferedReader; 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BufferedReaderDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "src/javase2/day02/demo.txt";
    BufferedReader in = 
      new BufferedReader(
          new InputStreamReader(
              new BufferedInputStream(
                  new FileInputStream(file)),"gbk"));
    //BufferedReader ��չ���ҳ�����ķ���readLine()
    //readLine() ���Դ��ļ���ÿ�ζ�ȡһ��(�س�)�ı�Ϊ�ַ���,
    //����ȡ���ļ�����ʱ��, ����null
    //Scanner in = new Scanner(System.in);
    //in.nextLine();//nextInt()
    String str;
    while((str = in.readLine())!=null){
      if(str.matches(".*��.*")){
        System.out.println(str);
      }
    }
    in.close();  
  }
}
