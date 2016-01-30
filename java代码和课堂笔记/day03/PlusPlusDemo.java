package basic.day03;
/** 自增运算演示 */
public class PlusPlusDemo {
  public static void main(String[] args) {
    int a = 1;
    int b;
    a++;
    ++a;
    System.out.println(a);//3
    a = 1;
    b=a++;
    //运算原则: 先执行++运算, 在执行赋值运算
    // 1 后++, 先取a的值 1, 作为a++表达式的值 1
    // 2 然后将a的值增加1, a变为2
    // 3 执行赋值运算, 将a++表达式的值1 赋值给变量b
    System.out.println("a:"+a+",b:"+b);//a:2,b:1
    a = 1;
    b = ++a;
    //运算原则: 先执行++运算, 在执行赋值运算
    // 1 先++, 先将a的值增加1, a变为2
    // 2 再将a的值2作为表达式++a的值
    // 3 将表达式++a的值 2 赋值给b
    System.out.println("a:"+a+",b:"+b);//a:2,b:2
    a = 1;
    a = a++;
    a = a++;
    a = a++;
    a = a++;
    // 1 后++, 先取a的值 1, 作为a++表达式的值 1
    // 2 然后将a的值增加1, a变为2
    // 3 执行赋值运算, 将a++表达式的值1 赋值给变量a
    System.out.println("a:"+a);//a:1
    
  }

}
