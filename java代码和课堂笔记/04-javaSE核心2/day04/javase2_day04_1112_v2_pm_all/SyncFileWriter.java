package javase2.day04;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
/** 同步处理
 * 同步播放: 边读取数据, 边播放数据
 * 同写文件: 边读取, 边写入
 * 代码简单, 但是用户感受很差
 * 
 * 如: 从控制台读取一行数据, 立即向一个目标文件写入一个数据
 *  */
public class SyncFileWriter {
  public static void main(String[] args) 
    throws IOException {
    String file = "sync.txt";
    //PrintWriter out = new PrintWriter(
    //    new FileWriter(file));
    PrintWriter out = new PrintWriter(
        new OutputStreamWriter(
            new FileOutputStream(file)));
    Scanner in = new Scanner(System.in);
    while(true){
      String str = in.nextLine();
      out.println(str);
      if(str.equals("q")){
        System.out.println("Bye");
        break;
      }
    }
    out.close();//如果忘记写close() 可能文件是空的!
  }
}





