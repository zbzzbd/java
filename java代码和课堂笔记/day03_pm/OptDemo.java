package basic.day03;

public class OptDemo {
  public static void main(String[] args) {
    byte b = -127;
    int i = 5 * b;
    System.out.println(i);
    int max = 0x7fffffff;
    int min = max+1;
    System.out.println(min);
    long l = max+1;//先计算max+1得到负数,然后再自动类型转换为long
    System.out.println(l);
    l = max+1L;//先将max转换为long类型, 再与1L相加
    l = (long)max+1;
    System.out.println(l);
    l = min * 2;
    System.out.println(l);//0
    l = (long)min * 2;
    System.out.println(l);
    
    int x = 5;
    int y = 2;
    int z = x/y;//整除
    System.out.println(z);
    double d = x/y;
    System.out.println(d);
    d = (double)x/y;
    System.out.println(d);
    d = x/100;//0.0
    d = x/100.0;//0.5
    d = x/100D;//(double)x/100
    
    //% 求余(取余 取模)运算
    z = 5%3;//2
    z = 3%3;//0
    
    z = 0%3;//0
    z = 1%3;//1
    z = 2%3;//2
    z = 3%3;//0
    z = 4%3;//1
    z = 5%3;//2
    z = 6%3;//0
    z = 7%3;//1
    z = 8%3;//2
    z = 9%3;//0
    
    //当 n>=0且m!=0时候,  0<= (n % m) < m 
    
    z = -5%3;//-2
    
    
    
  }

}


