package javase2.day01;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDemo {

  public static void main(String[] args)
    throws IOException {
    String file = "demo.dat";
    RandomAccessFile raf = 
      new RandomAccessFile(file, "rw");
    for(int i=-10; i<300; i++){
      raf.write(i);
    }
    raf.seek(0);
    int i=1;
    int b;
    while((b=raf.read())!=-1){
      System.out.print(Integer.toHexString(b)+":"+b+" ");
      if(i++%10==0){
        System.out.println(); 
      }
    }
    raf.close();
  }

}
