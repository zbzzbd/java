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
		System.out.println("新增方法");
	}
	
	public void show(){
		super.show();
		System.out.println("图形类型为：圆形");
		System.out.println("圆心为："+"("+core.getX()+","+core.getY()+")");
		System.out.println("半径为："+r);
		System.out.println("面积为："+area());
		System.out.println("周长为："+zhouchang());
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
