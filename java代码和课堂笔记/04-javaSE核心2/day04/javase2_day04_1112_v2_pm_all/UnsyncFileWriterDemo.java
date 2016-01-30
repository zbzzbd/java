package javase2.day04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class UnsyncFileWriterDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "unsync.txt";
    final Scanner console = new Scanner(System.in);
    final PrintWriter out = new PrintWriter(
        new OutputStreamWriter(
            new FileOutputStream(file)));
    //数据缓冲队列
    final LinkedList<String> buf=
      new LinkedList<String>();
    //writer 线程负责检查线性队列, 如果有数据就写入到文件中
    final Thread writer = new Thread(){
      public void run() {
        while(true){
          if(buf.isEmpty()){
            try {
              System.out.println("无数据, 休眠...");
              Thread.sleep(5000);
              continue;
            } catch (InterruptedException e) {
              e.printStackTrace();
              continue;
            }
          }
          String str = buf.removeFirst();
          System.out.println("写入:"+str); 
          out.println(str);
          out.flush();
        }
      }
    };
    writer.setDaemon(true);
    //reader 线程负责读取控制台信息, 写入到 线性队列
    final Thread reader = new Thread(){
      public void run() {
        while(true){
          String str = console.nextLine();
          buf.addLast(str);
          if(str.equals("q")){
            writer.interrupt();//提前唤醒writer
            break;
          }
        }
      }
    };
    writer.start();
    reader.start();    
  }
}
