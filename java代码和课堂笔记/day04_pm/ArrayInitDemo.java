package basic.day04;
/** 数组语法演示 */
public class ArrayInitDemo {
  public static void main(String[] args) {
    //变量是代词
    //对象是个体
    //代词关联了个体, 叫做: 变量引用了对象
    //System.out.println(ary[0]);//编译错误, 没有变量
    int[] ary;//声明了数组变量ary, 有变量,没有数组对象
    //System.out.println(ary[0]);//编译错误, 变量没有初始化
//  对数组变量进行初始化
    ary = new int[3];//new int[3] 是数组对象, 是个"个体"
    //数组对象成员默认自动初始化为 "零"值:
    // 0, 0.0, \u0000, false, null
    System.out.println(ary[0]);//访问数字成员(元素)
    System.out.println(ary[1]);
    System.out.println(ary[2]);
    //数组元素下标范围 0~length-1
    //System.out.println(ary[-1]);//运行异常, 不能越界访问
    //C++ = C Plus Plus = CPP
    int ary1[];//为了与cpp兼容提供的,其实Java内部没有,不建议用

    //数组对象的动态初始化
    int[] ary3 = new int[4];//务必指定数组长度
    //int[] ary4 = new int[];//编译错误
    int[] ary5 = new int[]{1,2,4,5};//直接给出数组元素
    
    //数组对象的静态初始化
    int[] ary6 = {2,3,4,5};//只能用于,声明变量时候直接初始化
    int[] ary7;
    //ary7 = {4,5,6,6};//编译错误! 静态初始化不能用来赋值
    ary7 = new int[]{4,5,6,7};//可以使用动态初始化
    
    //数组的访问: []运算可以读写数组元素, .length属性读取长度
    boolean[] used = new boolean[3];
    //读取数组元素
    System.out.println(used[0]);//false
    System.out.println(used[1]);//false
    System.out.println(used[2]);//false
    System.out.println(used.length);//3
    used[1] = true;//写入(更改)数组元素
    System.out.println(used[0]);//false
    System.out.println(used[1]);//true
    System.out.println(used[2]);//false

    used = new boolean[]{true, true};
    System.out.println(used[0]); 
    System.out.println(used[1]); 
    System.out.println(used[2]); 
    //数组变量, 数组对象, 数组元素 
    
  }

}





