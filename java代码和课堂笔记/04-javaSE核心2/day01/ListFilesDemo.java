package javase2.day01;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Comparator;
/** 列文件目录内容 */
public class ListFilesDemo {
  public static void main(String[] args) {
    //File dir = new File("/etc");
    //File f = new File("c:/test");// C:\\test
    //File.separator 分隔符: "\" or "/" java 会自动适应
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
    for(File file:files){//java 5 简化版的foreach迭代
      if(file.isDirectory()){
        System.out.println("["+file.getName()+"]");
      }else{
        System.out.println(file.getName());        
      }
    }
    //有条件的列目录: ls /etc|grep ^p.*
    // | \|
    System.out.println("有条件的列目录:^[pw].*");
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











