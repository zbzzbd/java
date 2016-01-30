package javase2.day03;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/** IO ������, �����ܶ�IO�йع��߷���(��̬����) */
public class IOUtils {
  
  public static Object deepCopy(Object obj){
    try {
      ByteArrayOutputStream buf = 
        new ByteArrayOutputStream();
      ObjectOutputStream out=new ObjectOutputStream(buf);
      out.writeObject(obj);
      out.close();
      byte[] data = buf.toByteArray();
      ObjectInputStream in = 
        new ObjectInputStream(
            new ByteArrayInputStream(data));
      Object copy = in.readObject();
      in.close();
      return copy;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
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
    //buf = {01000001,00001111,11010110,11010000}
    int i = 1;
    for (int b : buf) {
      //b =  00000000 00000000 00000000 01000001
      //0xff 00000000 00000000 00000000 11111111 mask
      // & ---------------------------------------
      //     00000000 00000000 00000000 01000001
      b &= 0xff;
     // b = b & 0xff;//�������� ���� 0xff ������(mask)
      
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
