package oop.day03;

public class ParamaterDemo {
  public static void main(String[] args) {
    int a=8; Koo k = new Koo();
    add(a); add(k);
    System.out.println(a+","+k.a);
    //选择输出结果: A.8,8  B.9,8  C.9,9  D.8,9 答案:D
    int[] aa = {8,8};
    add(aa);
    System.out.println(aa[0]);//9 
  }
  public static int add(int[] a){
    return ++a[0];
  }
  public static int add(int a){
    return ++a;
  }
  public static int add(Koo k){
    return ++k.a;
  }
}
class Koo{
  int a=8;
}
