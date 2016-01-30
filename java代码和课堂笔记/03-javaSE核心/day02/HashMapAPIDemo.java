package javase1.day02;

import java.util.Hashtable;
import java.util.Map;

/** ͳ��һ���ַ���ÿ���ַ������� */
public class HashMapAPIDemo {
  public static void main(String[] args) {
    String str = "aabbcdeffffff";
    //key�ǲ��ظ��ַ�����, value���ַ�����
    //�ַ�ʹ���ַ��İ�װ��Character, intʹ�ð�װ��Integer
    Map<Character, Integer> all = count(str);
    //Map<char, int> //�������!
    System.out.println(all);
  }
  public static Map<Character,Integer> count(String s){
    Hashtable<Character, Integer> map = 
      new Hashtable<Character, Integer>();
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      Integer num = map.get(c);//�������null��ʾû��
      map.put(c, num==null ? 1 : num+1);
//      if(map.containsKey(c)){//���map�Ƿ�ͳ�ƹ��ַ�c
//        int n = map.get(c);
//        map.put(c, n+1);//���ͳ�ƹ�, ��ȡ��+1 ��д��ȥ.
//      }else{
//        map.put(c, 1);//û�о͵�һͳ��Ϊ1
//      }
    }
    return map;
  }
}





