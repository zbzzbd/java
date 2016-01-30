package day09;
import java.io.*;
public class ListFilesDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "src" 
			+ File.separator
			+ "day13"
			+ File.separator;
		File file = new File(path);
		System.out.println("列出所有的文件：");//包括文件夹
		File[] allFiles = file.listFiles();
		for (File f : allFiles){
			System.out.println(f.getName());
		}
		System.out.println("列出所有的.java文件：");
		//返回所有的.java文件
		File[] files = file.listFiles(new FileFilter(){
			public boolean accept(File f) {
				return f.getName().endsWith(".java");
			}	
		});
		for(File f: files){
			System.out.println(f.getName());
		}
	}

}
