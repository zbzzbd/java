package day03;

public class Sample05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hero h = new Hero();
		h.huishangshu();
		h.liliang();
		//多态
		ICat c = new Hero();
//		c.liliang();//错误，看不见
		c.huishangshu();
		IBear b = new Hero();
//		b.huishangshu();//错误，看不见
		b.liliang();
	}

}
