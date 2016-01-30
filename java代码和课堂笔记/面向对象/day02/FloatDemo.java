package basic.day02;
/** 浮点数类型float, double */
public class FloatDemo {
  public static void main(String[] args) {
    //  457278  =  4.57278 * 10^5
    // 10100101010.11 = 1010010101.011 * 2
    // 10100101010.11 = 101001010.1011 * 2^10
    // 10100101010.11 = 10100101.01011 * 2^11    
    // 10100101010.11 = .1010010101011 * 2^1011
    

    //                 尾数          基数 指数
    //float的存储原理, 实际上非常复杂
    //float 32位,  1符号  8 位指数 23位尾数
    //存储原理:0 0000 1011 1010 0101 0101 1000 0000 000 
    //IEEE Float 
    int max = 0x7fffffff;//尾数有31位
    int a = 0x7ffffff0;//尾数有31位
    float f1 = max; //23位尾数
    float f2 = a;  //23位尾数
    System.out.println(f1==f2);//true
    System.out.println(max==a);//false
    //float 不能精确表示全部int类型
    //double 64位, 1 位符号,11位指数, 52位尾数
    double d1 = max;
    double d2 = a;
    System.out.println(d1==d2);//false
    System.out.println(d1-d2);//15.0
    //java 浮点数的字面量默认是double
    double d = 2.6;
    //float f = 2.6;//编译错误
    float f = 2.6F;//f/F 后缀是float类型 字面量
    //D/d 后缀是double 类型
    // 1 1L 1D 1F 1.0 
    //浮点数运算是不够精确的
    double z = d-2d;
    System.out.println(z);//0.6
    //建议不要进行浮点数的精确比较
    System.out.println(z==0.6);//false
    double pi = 3.1415926535897932384626;
    System.out.println(pi); 
 
    
  }
}








