package javase2.day01;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileSystemDemo {
  public static void main(String[] args) 
    throws IOException {
    //���´����൱������: pwd
    File work = new File(".");//·����Ϊ����
    //���ع淶�ľ���·��, �淶�ľ���·���в�����"."����".."
    String path = work.getCanonicalPath();
    System.out.println(path); 
    //Eclipse ��Ŀ�ĵ�ǰĿ¼��: ��Ŀ�ļ���
    //File ����:�ļ�/Ŀ¼, new File() ֻ�����ڴ��д���Java
    //����, ������Ӳ���ϴ����ļ���/�ļ�
    File demo = new File(work, "demo");//workĿ¼��demo
    System.out.println(demo.exists());//false
    if(! demo.exists()){
      demo.mkdir(); //����Ŀ¼
      //demo.mkdirs()//����ϵ��·��
    }
    System.out.println(demo.exists());//true
    File test = new File(demo, "test.txt");
    if(!test.exists()){
      test.createNewFile();//Ӳ���ϴ����˿հ��ļ� touch
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



