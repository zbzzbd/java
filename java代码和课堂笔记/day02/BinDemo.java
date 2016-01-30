package basic.day02;

public class BinDemo {
  public static void main(String[] args) {
    int i = 192;
    // 11000000
    //以二进制字符串形式输出整数
    System.out.println(Integer.toBinaryString(i)); 
    System.out.println(Integer.toBinaryString(152)); 
    System.out.println(Integer.toBinaryString(132)); 
    System.out.println(Integer.toBinaryString(-1)); 
    System.out.println(Integer.toBinaryString(-2)); 
    System.out.println(Integer.toBinaryString(-1)); 
    int max = 0x7fffffff;
    System.out.println(Integer.toBinaryString(max));
    System.out.println(Integer.toBinaryString(max+1)); 
    System.out.println(Integer.toBinaryString(~9));//-10
    //计算机内存只有 二进制补码
    //默认输出, 按照人习惯输出10机制结果
    //16进制是, 二进制的简写, 16进制本质就是2进制
    //16进制存在的价值: 方便书写2进制!
    int a =0xfffffffe;
    System.out.println(a);//-2
    System.out.println(Integer.toBinaryString(a));
    System.out.println(Integer.toHexString(a));
    int min = 0x80000000;
    //避免进行边界运行.
    int loan = max;//0x7fffffff
    loan = (loan +1) +(max+1);
    System.out.println(loan);//0
      
         
  }

}




