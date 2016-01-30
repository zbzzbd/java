package basic.day02;

/** 变量 */
public class VarDemo {
  public static void main(String[] args) {
    int age;//变量的声明
    age = 16;//变量的初始化
    //System.out.println(she);//编译错误, 未找到!
    String she;// 变量的声明, 有一个变量
    //System.out.println(she);//编译错误, 变量没有初始化
    she = "妲己";//变量的初始化, 为变量赋值
    System.out.println(she);
    if(age<18){
      int score = 100;//score 的作用域到if块结束
      //int age = 5;//编译错误
      age = 5;//同一个age, 重新赋值
      System.out.println(score);//100
    }//score 作用域结束 
    //System.out.println(score);//编译错误, 未找到
    int score = 1;//
    System.out.println(age);//5
    //int age = 5;//编译错误, 变量重定义!
    int times = 50;//声明直接初始化
    times = 100;//变量可以赋值, 就是修改值
    System.out.println(times);//100
  }
}






