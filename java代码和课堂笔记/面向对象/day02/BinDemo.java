package basic.day02;
 
/** 二进制测试*/
public class BinDemo {
  public static void main(String[] args) {
    int i = -1;
    System.out.println(Integer.toBinaryString(i));//32个1 
    System.out.println(i);//-1,java默认按照人都是习惯输出 
    
    System.out.println(Integer.toBinaryString(-10));
    System.out.println(Integer.toBinaryString(-9));
    System.out.println(Integer.toBinaryString(-8));
    System.out.println(Integer.toBinaryString(-7));
    System.out.println(Integer.toBinaryString(-6));
    System.out.println(Integer.toBinaryString(-5));
    System.out.println(Integer.toBinaryString(-4));
    System.out.println(Integer.toBinaryString(-3));
    System.out.println(Integer.toBinaryString(-2));
    System.out.println(Integer.toBinaryString(-1));
    System.out.println(Integer.toBinaryString(0));
    System.out.println(Integer.toBinaryString(1));
    System.out.println(Integer.toBinaryString(2));
    System.out.println(Integer.toBinaryString(3));
    System.out.println(Integer.toBinaryString(4));
    System.out.println(Integer.toBinaryString(5));

    int max = 0x7fffffff;
    int min = 0x80000000;
    System.out.println(max);//2G-1
    System.out.println(min);//-2G
    System.out.println(max+1);
    System.out.println(Integer.toBinaryString(max));
    System.out.println(Integer.toBinaryString(min));
    int a = 0xffffffff;//-1;
    System.out.println(a);//-1

    
  }

}
