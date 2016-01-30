package basic.day02;

public class IntDemo {
  public static void main(String[] args){
    int a = 5;//默认是int类型
    int b = 0xfffffff4;
    byte c = 5;//
    //byte d = 128;//编译错误
    //byte d = -129;//编译错误
    //byte d = 0x80;//编译错误, 128是正数
    byte d = 0xffffff80;//最小值 -128
    System.out.println(d); //-128
    long max = 0x7fffffffffffffffL;//l/L 表示long字面量
    //-1 -1L
    long l = -1; //自动符号位扩展现象,自动补充32个1
    System.out.println(l);//-1
    System.out.println(Long.toBinaryString(l));
    System.out.println(Long.toBinaryString(-1));//自动扩展
    byte e = -1;
    System.out.println(Integer.toBinaryString(e));//
  }
}
