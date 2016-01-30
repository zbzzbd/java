package javase1.day03;

import java.util.HashSet;
import java.util.Set;

/** 集合运算: 属于, 包含, 并, 交, 差 */
public class CollectionOptDemo {
  public static void main(String[] args) {
    Set<String> a = new HashSet<String>();
    a.add("Tom"); a.add("Andy"); a.add("Wang");
    Set<String> b = new HashSet<String>();
    b.add("Tom"); b.add("Robin"); b.add("John");
    Set<String> c = new HashSet<String>();
    c.add("Tom");  c.add("Andy");
    System.out.println("A:"+a);
    System.out.println("B:"+b);
    System.out.println("C:"+c);
    System.out.println("Tom 属于a:"+a.contains("Tom"));
    System.out.println("Tom 属于b:"+b.contains("Tom"));
    System.out.println("a 包含 c:" + a.containsAll(c));  
    System.out.println("a 包含 b:" + a.containsAll(b));  
    a.addAll(b); //将b很并到a
    System.out.println("将b很并到a"); 
    System.out.println("A:"+a);
    System.out.println("B:"+b);
    System.out.println("a交b");
    a.retainAll(b);//在a中保留, a b 的公共部分
    System.out.println("A:"+a);
    System.out.println("B:"+b);
    System.out.println("a-c");
    a.removeAll(c);// a中去除包含在c的元素
    System.out.println("A:"+a);
    System.out.println("c:"+c);
  }
}
