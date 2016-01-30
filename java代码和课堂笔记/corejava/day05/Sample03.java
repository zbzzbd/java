package day05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.println(test1("aaaab"));
//		System.out.println(test2("1111"));
		System.out.println(test3("021-324433"));

	}
	
	/**
	 * ���str����ֵ�Ƿ����a*b���ʽ
	 * @param str
	 * @return
	 */
	public static boolean test1(String str){
//		Pattern p = Pattern.compile("a*b");
//		Matcher matcher = p.matcher(str);
//		return matcher.matches();
		//��
		boolean b = Pattern.matches("a*b", str);
		return b;
	}
	
	/**
	 * ���str����ֵ�Ƿ�Ϊ����
	 * @param str
	 * @return
	 */
	public static boolean test2(String str){
		Pattern p = Pattern.compile("[0-9]+");
		Matcher matcher = p.matcher(str);
		return matcher.matches();
	}
	
	/**
	 * ���str����ֵ�Ƿ�Ϊ�绰���� 
	 * ָ����ʽΪ:XXX-XXXXXX����XXXX-XXXXXX
	 * @param str
	 * @return
	 */
	public static boolean test3(String str){
		Pattern p = Pattern.compile("[0-9]{3,4}-[0-9]{6}");
		Matcher matcher = p.matcher(str);
		return matcher.matches();
	}

}
