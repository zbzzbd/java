package javase2.day01;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileSystemDemo {
  public static void main(String[] args) 
    throws IOException {
    //如下代码相当于命令: pwd
    File work = new File(".");//路径名为参数
    //返回规范的绝对路径, 规范的绝对路径中不包含"."或者".."
    String path = work.getCanonicalPath();
    System.out.println(path); 
    //Eclipse 项目的当前目录是: 项目文件夹
    //File 代表:文件/目录, new File() 只是在内存中创建Java
    //对象, 不是在硬盘上创建文件夹/文件
    File demo = new File(work, "demo");//work目录下demo
    System.out.println(demo.exists());//false
    if(! demo.exists()){
      demo.mkdir(); //创建目录
      //demo.mkdirs()//创建系列路径
    }
    System.out.println(demo.exists());//true
    File test = new File(demo, "test.txt");
    if(!test.exists()){
      test.createNewFile();//硬盘上创建了空白文件 touch
    }
    // ls
    System.out.println("test is file:"+test.isFile());
    System.out.println("demo is dir:"+demo.isDirectory());
    System.out.println(demo.canExecute());
    System.out.println(demo.canRead());
    System.out.println(new Date(demo.lastModified()));
    test.delete();
    demo.delete();
  }
}



