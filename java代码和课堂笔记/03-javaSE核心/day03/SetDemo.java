package javase1.day03;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
  public static void main(String[] args) {
    Set<String> set = new HashSet<String>();
    set.add("Tom");
    set.add("Tom");
    set.add("Andy");
    set.add("John");
    set.add("Wang");
    System.out.println(set.size()); 
    System.out.println(set);
    
    Set<String> tree = new TreeSet<String>(set);//¸´ÖÆ
    System.out.println(tree.size()); 
    System.out.println(tree);
  }

}
