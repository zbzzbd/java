package oop.day04.fnl;
/** final 修饰的变量 */
public class FinalVarDemo {
  public static void main(String[] args) {
    //final 修饰的变量, 可以初始化, 变量值不能再修改
    final int a = 5;
    int b = 5;
    //a++;//编译错误, a不能再改了!
    b++;
    final int[] ary1 = {2,3};
    int[] ary2 = {3,4};
    ary1[0]=8;//对象元素可以修改
    //ary1 = ary2;//编译错, 变量ary1的值, 不能再修改!
    ary2[0]=8;
    ary2=ary1;
    final Soo s = new Soo();
    s.a = 8;
    //s = null;//编译错误, 变量s的值, 不能再修改!
    int x = add(4,5);//x=10
    
  }
  public static int add(final int a, int b){
    //a++;//编译错误, 变量a的值, 不能再修改!
    b++;
    return a+b;
  }
}
class Soo{
  int a=2;
  final int b = 5;
}



