package day01;

public class Point {
	private int x;

	private int y;

	public Point() {
		System.out.println("---�޲ι�����----");
	}
	
	public Point(Point p){
		this(p.x,p.y);//����Point(int x, int y)���췽��
	}

	public Point(int x, int y) {
		this();//����Point()���췽��,������ڵ�һ��
		this.x = x;
		this.y = y;
	}

	/**
	 * ����x,y��ԭ��ľ���
	 * 
	 * @return
	 */
	public double getDistan() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * ��ǰ���굽ָ�������ľ���
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public double getDistan(int x, int y) {
		return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y)
				* (this.y - y));
	}

	public double getDistan(Point p) {
//		return Math.sqrt((this.x - p.x) * (this.x - p.x) + (this.y - p.y)
//				* (this.y - p.y));
		return getDistan(p.x,p.y);
	}

	/**
	 * ������ʾ(x,y)
	 * 
	 * @return
	 */
	public void show() {
		System.out.println("(" + x + "," + y + ")");
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}
}
