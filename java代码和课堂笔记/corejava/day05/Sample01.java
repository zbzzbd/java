package day05;

public class Sample01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String s1 = "tom";//缓冲区中的对象
//		String s2 = "tom";//缓冲区中的对象
//		System.out.println(s1==s2);
//		String s3 = new String("tom");//强制开辟空间存储tom
//		String s4 = new String("tom");//强制开辟空间存储tom
//		System.out.println(s3==s4);
//		System.out.println(s1==s3);
//		test1();
//		test2();
//		test3();
//		count(null);
//		test4();
//		test5();
//		test6();
//		test7();
//		test9();
		String path = "D:\\myfile\\hello.java";
//		String path = "D:\\myfile\\day01\\Sample01.class";
		String name = getFileName(path);
		System.out.println("文件名:"+name);
		String type = getFileType(path);
		System.out.println("文件类型:"+type);
	}
	
	/**
	 * 统计str内包含的大写字母和小写字母的个数
	 * @param str
	 */
	public static void count(String str){
		int upper = 0;
		int lower = 0;
		if(str == null){
			return;
		}
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			if(c>='a' && c<='z'){
				lower++;
			}
			if(c>='A' && c<='Z'){
				upper++;
			}
		}
		System.out.println("大写字母"+upper+"个");
		System.out.println("小写字母"+lower+"个");
	}
	
	public static void test1(){
		String s = "ab中cd";
		for(int i=0;i<s.length();i++){
			System.out.println(s.charAt(i));
		}
	}
	
	public static void test2(){
		String str = "AbcE你fG";
//		str = str.toUpperCase();//将英文字母变大写
		str = str.toLowerCase();//将英文字母变小写
		System.out.println(str);
	}
	
	public static void test3(){
		String a = "ab c  ";
		String b = "efg";
		//a.trim过滤字符串a前面和后面的空白符
		a = a.trim()+b;//a = a.concat(b)
		System.out.println(a);
	}
	
	public static void test4(){
		System.out.println("a".compareTo("b"));
		System.out.println("abc".compareTo("abc"));
		System.out.println("az".compareTo("ab"));
		System.out.println("z".compareTo("ab"));
		System.out.println("a".compareTo("A"));
	}
	
	public static void test5(){
		System.out.println(" Hello张三".startsWith("Hello"));
		System.out.println("Hello张三".startsWith("Hello"));
		System.out.println("/个人/exam.doc".startsWith("/个人"));
		System.out.println("宝典.doc".endsWith(".doc"));
	}
	
	
	public static void test6(){
		//0  1   2  3  4  5
		//a  b   c  d  e  f
		System.out.println("abcdef".indexOf('g'));
		//转义字符\"
		System.out.println("ab\"def".indexOf('\"'));
		//返回cd第一次出现的位置
		System.out.println("abcdecdf".indexOf("cd"));
		//返回cd最后一次出现的位置
		System.out.println("abcdecdfcd".lastIndexOf("cd"));
	}
	
	
	public static void test7(){
		String str = "abcdefgadeg";
		str = str.replace('a', 'A');
		System.out.println(str);
		str = str.replaceAll("de","DE");
		System.out.println(str);
	}
	
	public static void test8(){
		String str = "计算机,旅游,爬山";
		String[] strArr = str.split(",");
		System.out.println(strArr.length);
		for(String s:strArr){
			System.out.println(s);
		}
	}
	
	public static void test9(){
		String file = "Hello.java";
		//取出索引大于等于6,一直到末尾的子串
		System.out.println(file.substring(6));
		//取出索引大于等于2,小于4的子串
		System.out.println(file.substring(2,4));
		int i = 10;
		//将其他类型转成字符串
		String s = i+"";
		String s1 = String.valueOf(i);
		//其他引用类型也可以使用toString()方法
	}
	
	/**
	 * 根据给定的路径，获取文件名
	 * @param path 文件路径 D:\myfile\hello.java
	 * D:\myfile\day01\Sample01.java
	 * @return hello.java Sample01.java
	 */
	public static String getFileName(String path){
		int index = path.lastIndexOf("\\")+1;
		return path.substring(index);
	}
	
	/**
	 * 根据给定的路径，获取文件类型
	 * @param path 文件路径 D:\myfile\hello.java
	 * D:\myfile\day01\Sample01.class
	 * @return .java .class
	 */
	public static String getFileType(String path){
		int index = path.lastIndexOf(".");
		return path.substring(index);
	}
	
}
