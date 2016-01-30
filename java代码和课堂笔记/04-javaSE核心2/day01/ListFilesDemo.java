package javase2.day01;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
/** ���ļ�Ŀ¼���� */
public class ListFilesDemo {
  public static void main(String[] args) {
    //File dir = new File("/etc");
    //File f = new File("c:/test");// C:\\test
    //File.separator �ָ���: "\" or "/" java ���Զ���Ӧ
    //File f = new File("c:"+File.separator+"test");

    File dir = new File("c:/windows");
    File[] files = dir.listFiles();//ls
    Arrays.sort(files, new Comparator<File>(){
      public int compare(File file1, File file2) {
        if(file1.isFile()==file2.isFile()){
          return file1.compareTo(file2);
        }
        return file1.isDirectory() ? -1 : 1;
      }
    });
//    for(int i=0;i<files.length; i++){
//      File file = files[i];
//    }
    for(File file:files){//java 5 �򻯰��foreach����
      if(file.isDirectory()){
        System.out.println("["+file.getName()+"]");
      }else{
        System.out.println(file.getName());        
      }
    }
    //����������Ŀ¼: ls /etc|grep ^p.*
    // | \|
    System.out.println("����������Ŀ¼:^[pw].*");
    files = dir.listFiles(new FileFilter(){
      public boolean accept(File file) {
        return file.getName().matches("^[pw].*") 
          && file.isDirectory(); 
      }
    });
    for (File file : files) {
      if(file.isDirectory()){
        System.out.println("["+file.getName()+"]");
      }else{
        System.out.println(file.getName());        
      }
    }
  }
}











