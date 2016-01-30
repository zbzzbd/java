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
    //BufferedReader 扩展出灰长方便的方法readLine()
    //readLine() 可以从文件中每次读取一行(回车)文本为字符串,
    //当读取到文件结束时候, 返回null
    //Scanner in = new Scanner(System.in);
    //in.nextLine();//nextInt()
    String str;
    while((str = in.readLine())!=null){
      if(str.matches(".*我.*")){
        System.out.println(str);
      }
    }
    in.close();  
  }
}
