package basic.day03;
/** 逻辑运算和比较运算 */
public class LogicDemo {
  public static void main(String[] args) {
    //逻辑运算: &&(and, 与, 并且), ||(或者, or), !(非, 否定)
    //比较运算: > >=(大于等于) < <=(小于等于), ==(相等), !=
    int age = 12;
    char sex = '男';
    boolean isChild = age<16;//是否是小孩
    boolean isMan = sex == '男';
    boolean isBoy = isChild && isMan;//是小孩并且是男的
    boolean isGirl = isChild && ! isMan;
    boolean isKid = isBoy || isGirl;
    System.out.println(isKid); 
    //非短路的逻辑运算: &(非短路的与) |(非短路的或)
    //六十岁以上老太太允许进来
    age = 66;
    sex = '男';
    //短路的与, 当第一个表达式不成立(false), 第二个就不再计算了
    if(sex=='女' && age++>60 ){//短路与运算
      System.out.println("老太太你身体真好, 请进!"); 
    }
    System.out.println(age);//66 说明: 第二个表达式被短路了
  
    age = 66;
    sex = '男';
//  非短路的与, 当第一个表达式不成立(false), 第二个还继续计算了
    //有些不合常理
    if(sex=='女' & age++>60 ){//非短路与运算
      System.out.println("老太太你身体真好, 请进!"); 
    }
    System.out.println(age);//67 说明: 第二个表达式被执行了
   
    //女的或者老头可以进来
    //短路的或 ||, 如果第一个表达式是true, 第二个就不再计算了
    age = 28;
    sex = '女';
    if(sex=='女' || age++ > 60){
      System.out.println("您好, 欢迎参观!"); 
    }
    System.out.println(age);//28
    
    //非短路的或 |, 不管第一个表达式是否执行, 都执行第二个表达式.
    age = 28;
    sex = '女';
    if(sex=='女' | age++ > 60){
      System.out.println("您好, 欢迎参观!"); 
    }
    System.out.println(age);//29
  }
}




