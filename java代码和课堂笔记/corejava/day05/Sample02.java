package day05;

public class Sample02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// test1();
		// test2();
		// test3();
		// test4();
		// test5();
		test6();
	}

	public static void test1() {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * ");
		sb.append("FROM emp ");
		sb.append("WHERE id=1 ");
		sb.append("AND name=tom ");
		sb.append("ORDER BY name ");
		String sql = sb.toString();
		System.out.println(sql);
	}

	public static void test2() {
		StringBuffer str = new StringBuffer("");
		for (int i = 1; i < 100; i++) {
			str.append(i);// 不推荐使用str+=i;
		}
		System.out.println(str.toString());
	}

	public static void test3() {
		StringBuffer str = new StringBuffer("abc");
		str.reverse();// 字符串反转变成cba
		System.out.println(str);
	}

	public static void test4() {
		StringBuffer str = new StringBuffer("abcdef");
		// str.delete(2, 3);//删除索引大于等于2，小于3的字符
		str.deleteCharAt(2);// 删除索引等于2的字符
		System.out.println(str);
	}

	public static void test5() {
		StringBuffer str = new StringBuffer("abcdef");
		str.insert(3, "ABC");// 3表示偏移量，即前面字符的个数
		System.out.println(str);
	}

	/**
	 * 将给定的str内容变成"13579"
	 */
	public static void test6() {
		StringBuffer str = new StringBuffer("123456789");
		for (int i = 1; i < str.length(); i++) {
			str.delete(i, i + 1);
		}
		System.out.println(str);
	}

	/**
	 * 将给定的str内容变成"1a2b3c4d5e6f"
	 */
	public static void test7() {
		StringBuffer str = new StringBuffer("1234567");
		for (int i = str.length(); i > 0; i--) {
			char n = (char) ((i - 1) + 'a');
			str.insert(i, n);
		}
		System.out.println(str);
	}

	// 不推荐
	// public static void test2(){
	// String sb = "SELECT * ";
	// sb+="FROM emp ";
	// sb+="WHERE id=1 ";
	// sb+="AND name=tom ";
	// sb+="ORDER BY name ";
	// System.out.println(sb);
	// }

}
