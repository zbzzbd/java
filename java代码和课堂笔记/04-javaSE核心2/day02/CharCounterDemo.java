package javase2.day02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/** 统计文件中中文数量 */
public class CharCounterDemo {
   
  public static void main(String[] args) {
    String file = "src/javase2/day02/demo.txt";
    Map<Character, Integer> map = count(file);
    System.out.println(map.get('的'));  
    //...排序, 输出top 10
  }
  
  public static Map<Character, Integer> 
    count(String file){
    try{
      HashMap<Character, Integer> map = 
        new HashMap<Character, Integer>();
      InputStreamReader in = 
        new InputStreamReader(
            new FileInputStream(file), "GBK");
      int ch;
      while((ch=in.read())!=-1){
        char c = (char)ch;
        Integer n = map.get(c);
        map.put(c, n==null ? 1 : n+1);
      }
      in.close();
      return map;
    }catch(IOException e){
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
}
