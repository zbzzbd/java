package day03;

public class Circle extends Shape{
	private Point core;
	private double r;

	
	public Circle(Point core,double r){
		this.core = core;
		this.r = r;
	}
	
	public Circle(int x,int y,double r){
		this.core = new Point(x,y); 
		this.r = r;
	}
	
	public void f1(){
		System.out.println("��������");
	}
	
	public void show(){
		super.show();
		System.out.println("ͼ������Ϊ��Բ��");
		System.out.println("Բ��Ϊ��"+"("+core.getX()+","+core.getY()+")");
		System.out.println("�뾶Ϊ��"+r);
		System.out.println("���Ϊ��"+area());
		System.out.println("�ܳ�Ϊ��"+zhouchang());
	}
	
	public double area(){
		return Math.PI*r*r;
	}
	
	public double zhouchang(){
		return 2*Math.PI*r;
	}
	
	
	public Point getCore() {
		return core;
	}
	public void setCore(Point core) {
		this.core = core;
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	
}
