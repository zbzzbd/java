package day09;
import java.io.*;
public class ListAllDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "src" + File.separator
			+ "day12" + File.separator;
		//String path = "src";
		File file = new File(path);//文件夹的根
		list(file);
	}
	/**
	 * 列出参数file对象下的所有文件和文件夹
	 * @param file
	 */
	private static void list(File file) {
		//1.显示当前目录的所有文件,不要目录
		File [] files = file.listFiles(new FileFilter(){
			public boolean accept(File f) {
				return f.isFile();
			}
		});
		System.out.println("文件夹" +file.getName() + "下的文件：");
		for(File f : files){
			System.out.println(f.getName());
		}
		//2.显示当前目录的所有子目录，不要文件
		File [] dirs = file.listFiles(new FileFilter(){
			public boolean accept(File f) {
				return f.isDirectory();
			}
		});
		for(File dir : dirs){
			list(dir);//递归调用
		}
	}

}
