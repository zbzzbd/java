package basic.day03;


public class MethodDemo {
  public static void main(String[] args) {
    int x = 5;
    int y = f(x);//函数的调用. y=f(x)=3x+2;
    //f=Function, 功能
    System.out.println(y);
  }
  /** 函数(方法)的声明 */
  public static int f(int x){//变量x和y的作用域是当前方法
    int y = 3*x+2;
    return y;//如果定义了返回值类型, 就必须使用return返回值
  }
}
