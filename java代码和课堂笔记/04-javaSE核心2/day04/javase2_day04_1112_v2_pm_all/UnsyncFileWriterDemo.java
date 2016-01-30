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
    //���ݻ������
    final LinkedList<String> buf=
      new LinkedList<String>();
    //writer �̸߳��������Զ���, ��������ݾ�д�뵽�ļ���
    final Thread writer = new Thread(){
      public void run() {
        while(true){
          if(buf.isEmpty()){
            try {
              System.out.println("������, ����...");
              Thread.sleep(5000);
              continue;
            } catch (InterruptedException e) {
              e.printStackTrace();
              continue;
            }
          }
          String str = buf.removeFirst();
          System.out.println("д��:"+str); 
          out.println(str);
          out.flush();
        }
      }
    };
    writer.setDaemon(true);
    //reader �̸߳����ȡ����̨��Ϣ, д�뵽 ���Զ���
    final Thread reader = new Thread(){
      public void run() {
        while(true){
          String str = console.nextLine();
          buf.addLast(str);
          if(str.equals("q")){
            writer.interrupt();//��ǰ����writer
            break;
          }
        }
      }
    };
    writer.start();
    reader.start();    
  }
}
