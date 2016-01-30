package javase2.day02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/** IO ������, �����ܶ�IO�йع��߷���(��̬����) */
public class IOUtils {
  
  public static void cp(String src, String dst){
    try {
      InputStream in = new FileInputStream(src);
      OutputStream out = new FileOutputStream(dst);
      byte[] buf = new byte[2*1024];//2k byte
      int n;
      while((n=in.read(buf))!=-1){
        out.write(buf, 0, n);
      }
      in.close();
      out.close();
    } catch (IOException  e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  
  public static void cp1(String src, String dst){
    try {
      InputStream in = new FileInputStream(src);
      OutputStream out = new FileOutputStream(dst);
      int b;
      while((b=in.read())!=-1){
        out.write(b);
      }
      in.close();
      out.close();
    } catch (IOException  e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  public static void print(File file){
    try{
      InputStream in = new FileInputStream(file);
      int i=1;
      int b;
      while((b=in.read())!=-1){
        if(b<=0xf){//��λ����0
          System.out.print("0");
        }
        System.out.print(Integer.toHexString(b)+" ");
        if(i++%16==0){
          System.out.println();
        }
      }
      System.out.println(); 
      in.close();//ע��
    }catch(IOException e){
      e.printStackTrace();
      throw new RuntimeException(e);
    }

  }
  public static void print(byte[] buf){
    int i = 1;
    for (int b : buf) {
      b &= 0xff;
      if (b <= 0xf) {// ��λ����0
        System.out.print("0");
      }
      System.out.print(Integer.toHexString(b) + " ");
      if (i++ % 16 == 0) {
        System.out.println();
      }
    }
    System.out.println(); 
  }
  /** ���ļ�����16�������������̨��, ÿ16��byteΪһ�� */
  public static void print(String file){
    try{
      InputStream in = new FileInputStream(file);
      int i=1;
      int b;
      while((b=in.read())!=-1){
        if(b<=0xf){//��λ����0
          System.out.print("0");
        }
        System.out.print(Integer.toHexString(b)+" ");
        if(i++%16==0){
          System.out.println();
        }
      }
      System.out.println(); 
      in.close();//ע��
    }catch(IOException e){
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
