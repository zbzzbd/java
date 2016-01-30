package javase1.day03;

import java.util.ArrayList;
import java.util.List;

/** 包装类  */
public class WorpClassDemo {
  public static void main(String[] args) {
    //基本类型没有父类型, 不继承Object
    //Java提供包装类,将基本类型包装为对象,解决了"数也是东西"
    //Java 有两种数: int, Integer 都是整数
    // 包装类型的 数是对象在堆中
    Integer i = new Integer(5);//i 引用对象 "5"
    //Java 有八种包装类, 对应8中基本类型
    Double d = new Double(6.6);
    
    //包装类提供了"最基本的数据输入输出处理方法":
    //人能够识别数据是:String 如: "30"
    //计算机能够处理的数据是二进制(补码): 00011110
    //包装提供了将 "30"转换为二进制数据(int)的方法
    int x = Integer.parseInt("30");
    int y = Integer.parseInt("f", 16);
    // console.nextInt() 方法的底层就用了 parseInt()
    double dx = Double.parseDouble("5.5");
    
    //包装类还提供了将二进制数据转换为 人能够看懂的String方法
    x = 0xffffffff;
    System.out.println(x);//-1 
    System.out.println(Integer.toString(x)); 
    dx = 6.5;
    System.out.println(Double.toString(dx));  
    
    //Java 5 提供了自动包装/拆包功能:
    Integer j = 5;//new Integer(5); 
    Boolean b = true;
    Object o = 5.5;//new Double(5.5)
    Number n = 6;//new Integer(6)
    Double s = (Double)o;
    //自动拆包
    int k = j+1;//k = j.intValue() + 1
    j = j + 1;// j = new Integer(j.intValue()+1)
    k = k+1;
    
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(5);
    list.add(8);
    list.add(13);
    System.out.println(list); 
    int f = list.get(3);
    System.out.println(f);  
   
    Integer aa = new Integer(1);
    Integer bb = new Integer(1);
    System.out.println(aa==bb);//false
    System.out.println(aa.equals(bb));//true
       
    Integer cc = 1;
    Integer dd = 1;
    System.out.println(cc==dd);//true
    
    
  }
}
