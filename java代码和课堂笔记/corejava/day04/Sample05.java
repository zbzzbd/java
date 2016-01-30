package day04;

public class Sample05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Point p = new Point(3,5);
//		String str = p.toString();
//		System.out.println(str);
//		System.out.println(p);
//		String s1 = new String("tom");
//		String s2 = new String("tom");
//		System.out.println(s1==s2);
//		System.out.println(s1.equals(s2));
		Point p1 = new Point(3,5);
		Point p2 = new Point(3,5);
		System.out.println(p1==p2);
		System.out.println(p1.equals(p2));
		System.out.println(p2.equals(p1));
	}
}
