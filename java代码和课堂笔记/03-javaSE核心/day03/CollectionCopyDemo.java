package javase1.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** 集合的复制 */
public class CollectionCopyDemo {
  public static void main(String[] args) {
    ArrayList<String> cards = new ArrayList<String>();
    cards.add("红桃6"); 
    cards.add("红桃7"); 
    cards.add("红桃8"); 
    cards.add("红桃9");
    ArrayList<String> cards2 = cards;
    cards2.set(2, "大王");
    System.out.println(cards);
    System.out.println(cards2); 
    //clone 用来创建 对象的"浅表"副本,返回同类型的集合副本
    ArrayList<String> copy = 
      (ArrayList<String>)cards.clone();
    copy.set(2, "小王");
    System.out.println(cards);
    System.out.println(copy);
    System.out.println(cards==copy);//false 集合复制了
    //集合元素引用的对象没有复制
    System.out.println(cards.get(0)==copy.get(0));//true
    //Java 中默认的对象数组复制也是浅表复制
    Object[] ary = {1, 2, 3};//发生自动包装现象
    Object[] ary2 = Arrays.copyOf(ary, ary.length);
    System.out.println(ary==ary2);//false
    System.out.println(ary[0]==ary2[0]);//true
    
    //集合常见的复制, 使用复制构造器实现
    //所有的Java集合类都有复制构造器, 复制构造器的参数是
    //另外的一个集合对象, 是Collection实例都行
    
    Set<String> set = new HashSet<String>(cards);
    System.out.println(set);//副本
    
    
    
  }
}







