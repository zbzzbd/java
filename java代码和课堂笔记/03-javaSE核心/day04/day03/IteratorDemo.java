package javase1.day03;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class IteratorDemo {
  public static void main(String[] args) {
    Collection<String> eggs = new HashSet<String>();
    eggs.add("鸡蛋");
    eggs.add("鸭蛋");
    eggs.add("松花蛋");
    eggs.add("好蛋");
    eggs.add("坏蛋");
    int count=0;
    System.out.println(eggs);
    Iterator<String> ite = eggs.iterator();
    while(ite.hasNext()){
      String egg = ite.next();
      System.out.println(egg);
      count++;
      if(egg.equals("坏蛋")){
        ite.remove();//从原集合eggs中,删除正在迭代的元素
      }
    }
    System.out.println(count);//5
    System.out.println(eggs);
  }
}






