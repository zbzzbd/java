package day03;

public class Sample05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Hero h = new Hero();
		h.huishangshu();
		h.liliang();
		//��̬
		ICat c = new Hero();
//		c.liliang();//���󣬿�����
		c.huishangshu();
		IBear b = new Hero();
//		b.huishangshu();//���󣬿�����
		b.liliang();
	}

}
