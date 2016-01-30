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
		File file = new File(path);//�ļ��еĸ�
		list(file);
	}
	/**
	 * �г�����file�����µ������ļ����ļ���
	 * @param file
	 */
	private static void list(File file) {
		//1.��ʾ��ǰĿ¼�������ļ�,��ҪĿ¼
		File [] files = file.listFiles(new FileFilter(){
			public boolean accept(File f) {
				return f.isFile();
			}
		});
		System.out.println("�ļ���" +file.getName() + "�µ��ļ���");
		for(File f : files){
			System.out.println(f.getName());
		}
		//2.��ʾ��ǰĿ¼��������Ŀ¼����Ҫ�ļ�
		File [] dirs = file.listFiles(new FileFilter(){
			public boolean accept(File f) {
				return f.isDirectory();
			}
		});
		for(File dir : dirs){
			list(dir);//�ݹ����
		}
	}

}
