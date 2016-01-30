package day01;

public class Point {
	private int x;

	private int y;

	public Point() {
		System.out.println("---无参构造器----");
	}
	
	public Point(Point p){
		this(p.x,p.y);//调用Point(int x, int y)构造方法
	}

	public Point(int x, int y) {
		this();//调用Point()构造方法,必须放在第一行
		this.x = x;
		this.y = y;
	}

	/**
	 * 返回x,y到原点的距离
	 * 
	 * @return
	 */
	public double getDistan() {
		return Math.sqrt(x * x + y * y);
	}

	/**
	 * 求当前坐标到指定坐标点的距离
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
	 * 坐标显示(x,y)
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
