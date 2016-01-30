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
		System.out.println("ͼ������Ϊ������");
		System.out.println("��Ϊ��"+height);
		System.out.println("��Ϊ��"+width);
		System.out.println("���Ϊ��"+area());
		System.out.println("�ܳ�Ϊ��"+zhouchang());
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
