package day05;

public class Sample01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String s1 = "tom";//�������еĶ���
//		String s2 = "tom";//�������еĶ���
//		System.out.println(s1==s2);
//		String s3 = new String("tom");//ǿ�ƿ��ٿռ�洢tom
//		String s4 = new String("tom");//ǿ�ƿ��ٿռ�洢tom
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
		System.out.println("�ļ���:"+name);
		String type = getFileType(path);
		System.out.println("�ļ�����:"+type);
	}
	
	/**
	 * ͳ��str�ڰ����Ĵ�д��ĸ��Сд��ĸ�ĸ���
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
		System.out.println("��д��ĸ"+upper+"��");
		System.out.println("Сд��ĸ"+lower+"��");
	}
	
	public static void test1(){
		String s = "ab��cd";
		for(int i=0;i<s.length();i++){
			System.out.println(s.charAt(i));
		}
	}
	
	public static void test2(){
		String str = "AbcE��fG";
//		str = str.toUpperCase();//��Ӣ����ĸ���д
		str = str.toLowerCase();//��Ӣ����ĸ��Сд
		System.out.println(str);
	}
	
	public static void test3(){
		String a = "ab c  ";
		String b = "efg";
		//a.trim�����ַ���aǰ��ͺ���Ŀհ׷�
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
		System.out.println(" Hello����".startsWith("Hello"));
		System.out.println("Hello����".startsWith("Hello"));
		System.out.println("/����/exam.doc".startsWith("/����"));
		System.out.println("����.doc".endsWith(".doc"));
	}
	
	
	public static void test6(){
		//0  1   2  3  4  5
		//a  b   c  d  e  f
		System.out.println("abcdef".indexOf('g'));
		//ת���ַ�\"
		System.out.println("ab\"def".indexOf('\"'));
		//����cd��һ�γ��ֵ�λ��
		System.out.println("abcdecdf".indexOf("cd"));
		//����cd���һ�γ��ֵ�λ��
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
		String str = "�����,����,��ɽ";
		String[] strArr = str.split(",");
		System.out.println(strArr.length);
		for(String s:strArr){
			System.out.println(s);
		}
	}
	
	public static void test9(){
		String file = "Hello.java";
		//ȡ���������ڵ���6,һֱ��ĩβ���Ӵ�
		System.out.println(file.substring(6));
		//ȡ���������ڵ���2,С��4���Ӵ�
		System.out.println(file.substring(2,4));
		int i = 10;
		//����������ת���ַ���
		String s = i+"";
		String s1 = String.valueOf(i);
		//������������Ҳ����ʹ��toString()����
	}
	
	/**
	 * ���ݸ�����·������ȡ�ļ���
	 * @param path �ļ�·�� D:\myfile\hello.java
	 * D:\myfile\day01\Sample01.java
	 * @return hello.java Sample01.java
	 */
	public static String getFileName(String path){
		int index = path.lastIndexOf("\\")+1;
		return path.substring(index);
	}
	
	/**
	 * ���ݸ�����·������ȡ�ļ�����
	 * @param path �ļ�·�� D:\myfile\hello.java
	 * D:\myfile\day01\Sample01.class
	 * @return .java .class
	 */
	public static String getFileType(String path){
		int index = path.lastIndexOf(".");
		return path.substring(index);
	}
	
}
