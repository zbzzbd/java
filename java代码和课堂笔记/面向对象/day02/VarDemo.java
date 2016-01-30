package basic.day02;

public class VarDemo {
  public static void main(String[] args) {
    int age;//"变量的声明"int是变量的类型，是整数类型 
    //age是变量名, 建议有实际意义的变量名
    //System.out.println(age);//编译错误, 变量没有初始化!,
    //读取变量的值并输出.
    age = 12;//"变量的初始化" 就是第一次复制
    System.out.println(age);//12
    //int age; //编译错误, 变量不能重复定义
    age = 14;//"变量的赋值" 是第一次以后再修改变量的值
    System.out.println(age);//14
    //System.out.println(score);//编译错,没有score
    int score = 100;//声明变量同时初始化
    System.out.println(score);//100
    //变量的作用域: 从声明的地方开始到块的结束,
    //变量离开作用域就回收
    if(age<16){
      //int score = 40;//编译错. 变量重定义!
      int times = 200;
      System.out.println(times); //200
    }
    //System.out.println(times);//编译错误, 没有times
    int times = 100;//没有问题, 不是重定义
    System.out.println(times); //100
  }
}
