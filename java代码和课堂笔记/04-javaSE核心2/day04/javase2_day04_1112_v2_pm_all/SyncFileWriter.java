package javase2.day04;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
/** ͬ������
 * ͬ������: �߶�ȡ����, �߲�������
 * ͬд�ļ�: �߶�ȡ, ��д��
 * �����, �����û����ܺܲ�
 * 
 * ��: �ӿ���̨��ȡһ������, ������һ��Ŀ���ļ�д��һ������
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
    out.close();//�������дclose() �����ļ��ǿյ�!
  }
}





