package com.fuxi1;

public class StaticDemo {

	public static void main(String[] args) {
		Koo.a=1;
		Koo k1 = new Koo();
		Koo k2=new Koo();
		System.out.println(k2.b+","+k1.a+","+k2.a);
	}
}
class Koo{ 
	static int a=1;
 int b=0;
   public Koo(){
	   a=b++;
   }
   
   
   
}