package javase1.day03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionsDemo {
  public static void main(String[] args) {
    List<String> names = new ArrayList<String>();
    names.add("Tom");
    names.add("Andy");
    names.add("Wang");
    names.add("Robin");
    names.add("Tom");
    Collections.sort(names);//排序
    System.out.println(names);
    //字符串是如何排序的?答:字符串可以比较大小, 根据大小排序
    //字符串是如何比较大小的?答:字符串提供了比较大小的方法:
//  A.comapreTo(B), 返回>0 则 A>B
//  A.comapreTo(B), 返回==0 则 A==B
//  A.comapreTo(B), 返回<0 则 A<B
    System.out.println("Bob".compareTo("Andy"));//1
    System.out.println("Andy".compareTo("Andy"));//0
    System.out.println("Andy".compareTo("Bob"));//-1
    //compareTo() 方法是在Comparable 接口中定义, 
    //String实现了这个接口, 和这个方法.
    //Comparable: 形容词: 可以比较大小的
    //String实现了这个接口 表示: String 是 "可以比较大小的"!
    //Comparable 比较少使用: 不是所有类的实例都可以默认比较
    // 大小的: 如两个人, 不能默认比较大小, 人可以自定义比较.
    //compareTo() 方法的实现必须与equals() 结果一致!
    //Comparator: 名词: 比较器 , 这个接口表示临时自定义
    //比较规则, 方便\灵活\常用!
    Collections.sort(names, new ByLength());
    System.out.println(names);//自定义比较结果
    Collections.sort(names, new ByLast());
    System.out.println(names);//自定义比较结果
    
    Collections.reverse(names);//反转
    System.out.println(names);
    
    Collections.sort(names);//排序
    System.out.println(names);
    //二分查找
    int index = Collections.binarySearch(names, "Tom");
    System.out.println(index); 
    
  }
}
/** 自定义比较工具, 按照字符串长度比较 */
class ByLength implements Comparator<String>{
  public int compare(String o1, String o2) {
    return -(o1.length() - o2.length());
  }
}
class ByLast implements Comparator<String>{
  public int compare(String o1, String o2) {
    return -(o1.charAt(o1.length()-1) - 
             o2.charAt(o2.length()-1) );
  }
}





