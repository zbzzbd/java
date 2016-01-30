package javase1.day02;

import java.util.Hashtable;
import java.util.Map;

/** 统计一段字符中每个字符的数量 */
public class HashMapAPIDemo {
  public static void main(String[] args) {
    String str = "aabbcdeffffff";
    //key是不重复字符数量, value是字符个数
    //字符使用字符的包装类Character, int使用包装类Integer
    Map<Character, Integer> all = count(str);
    //Map<char, int> //编译错误!
    System.out.println(all);
  }
  public static Map<Character,Integer> count(String s){
    Hashtable<Character, Integer> map = 
      new Hashtable<Character, Integer>();
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      Integer num = map.get(c);//如果返回null表示没有
      map.put(c, num==null ? 1 : num+1);
//      if(map.containsKey(c)){//检查map是否统计过字符c
//        int n = map.get(c);
//        map.put(c, n+1);//如果统计过, 就取出+1 并写回去.
//      }else{
//        map.put(c, 1);//没有就第一统计为1
//      }
    }
    return map;
  }
}





