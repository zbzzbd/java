package basic.day02;

public class IntegerDemo {
  public static void main(String[] args) {
    int balance = 0x7fffffff;
    balance = balance + 1 + balance + 1;
    //这里最终溢出以后结果为0!要避免补码运算溢出的副作用!
    System.out.println(balance);//0
    // 01111111 11111111 11111111 11111111
    //+00000000 00000000 00000000 00000001
    // 10000000 00000000 00000000 00000000
    
    // 01111111 11111111 11111111 11111111
    //+00000000 00000000 00000000 00000001
    // 10000000 00000000 00000000 00000000
    
    //  10000000 00000000 00000000 00000000
    //+ 10000000 00000000 00000000 00000000
    //  00000000 00000000 00000000 00000000
    int max = 0x7fffffff;
    long l = max + 1 + max + 1;
    System.out.println(l);//0
    long l1 = (long)max + (long)1 + max + 1;
    System.out.println(l1);//4G
    
    byte age = 12;//java底层使用int处理
    short s = 128;
    //int 使用最多
    //直接给出量/直接量/字面量 整数是int类型
    int a = 5;
    int b = 0xff;
    int c = 010;//八进制
    //int 类型的字面量如果没有超过范围可以给小类型赋值
    //byte x = 128;//编译错
    byte x = 127;
    byte y = (byte)128;//10000000
    System.out.println(y);//-128
    //以L/l为后缀,表示long类型的字面量
    long e = 1L;
    //long longMax = 0x7fffffffffffffff;//编译错,字面量超int范围 
    long longMax = 0x7fffffffffffffffL; 
     
  }
}







