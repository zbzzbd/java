package javase1.day03.ext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
/**
 * Map有3种迭代方法: 迭代所有key, 迭代所有value 和 
    迭代Entey(key:value)

 *
 */
public class HashMapDemo {
  public static void main(String[] args) {
    String str = "匿名类是对原类的一个继承，" +
        "同时创建了实例，{} 就是继承"+
        "以后的类体。类体中可使用所有类的语法。"+
        " 匿名类不能写构造器。";
    Map<Character, Integer> map = count(str);
    System.out.println(map); 
    //1 计算总字符数量, 累加结果中所有的Values
    //2 忽略字符, 使用HashSet实现
    //3 排序输出 top 10
    //map.values() 返回所有的value 的集合
    //对Map集合的一种迭代方式: 迭代所有的值(value)
    Collection<Integer> values = map.values();
    System.out.println(values);//所有value的集合
    int chars = 0;//字符数量
    for(Iterator<Integer> i=values.iterator();
      i.hasNext();){
      int n = i.next();
      chars+=n;//累加每个字符统计结果
    }
    System.out.println("总字符数量:"+chars); 
    //迭代输出Map集合中的每个<key:value>元素
    //map.entrySet()返回Set(元素不重复)集合, 每个元素
    //的类型是Entry类型, 每个entry元素包含属性key和Value, 
    //每个元素代表map中的key:value对
    Set<Entry<Character, Integer>> entrySet = 
      map.entrySet();
    System.out.println(entrySet); 
    //通过迭代entrySet变通的迭代Map集合, Map不能直接迭代
    for (Iterator<Entry<Character, Integer>> i = 
        entrySet.iterator(); i.hasNext();) {
      Entry<Character, Integer> entry = i.next();
      System.out.print(entry.getKey()+"\t");//取出统计字符
      System.out.print(entry.getValue()+"\t");//取出字符数量
      System.out.println(
          (double)entry.getValue()/chars*100+"%");
    }
    //Map有3种迭代方法: 迭代所有key, 迭代所有value 和 
    // 迭代Entey(key:value)
    //迭代map中所有key的集合, 实现输出统计结果
    Set<Character> keys=map.keySet();//返回所有key的集合
    System.out.println(keys);
    System.out.println("迭代keys"); 
    for(Iterator<Character> i=keys.iterator();
      i.hasNext();){
      Character ch = i.next();//每个key是统计结果中的字符
      Integer n = map.get(ch);//利用key查找value
      System.out.println(ch+":"+n+","+
          ((double)n/chars*100));
    }
    List<Entry<Character, Integer>> list = 
      new ArrayList<Entry<Character,Integer>>();
    list.addAll(map.entrySet());
    Collections.sort(list, new ByValue());//排序, 是对List集合进行排序
    int index = 0;
    for (Iterator<Entry<Character, Integer>> i = 
      list.iterator(); i.hasNext();) {
      Entry<Character, Integer> entry = i.next();
      Character ch = entry.getKey();
      Integer n = entry.getValue();
      System.out.println((index++)+":"+ch+":"+n+":"+
          ((double)n/chars*100)+"%");
      if(index==10){
        break;
      }
    }
  }
  public static Map<Character, Integer> count(
      String str){
    HashMap<Character, Integer> map = 
      new HashMap<Character, Integer>();
    HashSet<Character> ignore = 
      new HashSet<Character>();//被忽略的字符集合
    ignore.add(' ');
    ignore.add('\t');
    ignore.add('。');
    ignore.add('，');    
    for(int i=0; i<str.length(); i++){
      char ch = str.charAt(i);
      if(ignore.contains(ch)){//忽略字符包含ch就处理下一个
        continue;
      }
      Integer n = map.get(ch);
      map.put(ch, n==null? 1 : n+1);
    }
    return map;
  }
}
class ByValue 
  implements Comparator<Entry<Character, Integer>>{
  public int compare(Entry<Character, Integer> o1,
      Entry<Character, Integer> o2) {
    return -(o1.getValue()-o2.getValue());
  }
}

