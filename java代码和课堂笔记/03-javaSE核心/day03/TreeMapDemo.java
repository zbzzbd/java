package javase1.day03;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {
  public static void main(String[] args) {
    Map<String, String> map = 
      new TreeMap<String, String>();
    map.put("Tom", "Tom Wang");
    map.put("Tom", "Tom Wang");
    map.put("Andy", "Andy Liu");
    map.put("John", "John Lee");
    map.put("Robin", "Robin Liu");
    System.out.println(map.size());//4
    System.out.println(map);//keyÅÅÐò½á¹û
  }
}
