package day04;

public class Point {
	private int x;

	private int y;

	public Point() {
	}

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	/**
	 * 重写了Object父类中的toString方法
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}

	/**
	 * 重写了Object父类中的equals方法,比较两个对象的内容 如果x,y的值相等返回true,否则返回false
	 */
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Point p = (Point) obj;
		if (this.x == p.x && this.y == p.y) {
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return Integer.valueOf(x).hashCode() + Integer.valueOf(y).hashCode();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
