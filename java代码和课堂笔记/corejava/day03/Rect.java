package day03;

public class Rect extends Shape {
	private double width;
	private double height;
	
	public Rect(double width,double height){
		this.width = width;
		this.height = height;
	}
	
	public void show(){
		super.show();
		System.out.println("图形类型为：矩形");
		System.out.println("高为："+height);
		System.out.println("宽为："+width);
		System.out.println("面积为："+area());
		System.out.println("周长为："+zhouchang());
	}
	
	public double area(){
		return width*height;
	}
	
	public double zhouchang(){
		return 2*(width+height);
	}
	
	
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
}
