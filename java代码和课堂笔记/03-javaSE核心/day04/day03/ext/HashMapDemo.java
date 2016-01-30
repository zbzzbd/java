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
 * Map��3�ֵ�������: ��������key, ��������value �� 
    ����Entey(key:value)

 *
 */
public class HashMapDemo {
  public static void main(String[] args) {
    String str = "�������Ƕ�ԭ���һ���̳У�" +
        "ͬʱ������ʵ����{} ���Ǽ̳�"+
        "�Ժ�����塣�����п�ʹ����������﷨��"+
        " �����಻��д��������";
    Map<Character, Integer> map = count(str);
    System.out.println(map); 
    //1 �������ַ�����, �ۼӽ�������е�Values
    //2 �����ַ�, ʹ��HashSetʵ��
    //3 ������� top 10
    //map.values() �������е�value �ļ���
    //��Map���ϵ�һ�ֵ�����ʽ: �������е�ֵ(value)
    Collection<Integer> values = map.values();
    System.out.println(values);//����value�ļ���
    int chars = 0;//�ַ�����
    for(Iterator<Integer> i=values.iterator();
      i.hasNext();){
      int n = i.next();
      chars+=n;//�ۼ�ÿ���ַ�ͳ�ƽ��
    }
    System.out.println("���ַ�����:"+chars); 
    //�������Map�����е�ÿ��<key:value>Ԫ��
    //map.entrySet()����Set(Ԫ�ز��ظ�)����, ÿ��Ԫ��
    //��������Entry����, ÿ��entryԪ�ذ�������key��Value, 
    //ÿ��Ԫ�ش���map�е�key:value��
    Set<Entry<Character, Integer>> entrySet = 
      map.entrySet();
    System.out.println(entrySet); 
    //ͨ������entrySet��ͨ�ĵ���Map����, Map����ֱ�ӵ���
    for (Iterator<Entry<Character, Integer>> i = 
        entrySet.iterator(); i.hasNext();) {
      Entry<Character, Integer> entry = i.next();
      System.out.print(entry.getKey()+"\t");//ȡ��ͳ���ַ�
      System.out.print(entry.getValue()+"\t");//ȡ���ַ�����
      System.out.println(
          (double)entry.getValue()/chars*100+"%");
    }
    //Map��3�ֵ�������: ��������key, ��������value �� 
    // ����Entey(key:value)
    //����map������key�ļ���, ʵ�����ͳ�ƽ��
    Set<Character> keys=map.keySet();//��������key�ļ���
    System.out.println(keys);
    System.out.println("����keys"); 
    for(Iterator<Character> i=keys.iterator();
      i.hasNext();){
      Character ch = i.next();//ÿ��key��ͳ�ƽ���е��ַ�
      Integer n = map.get(ch);//����key����value
      System.out.println(ch+":"+n+","+
          ((double)n/chars*100));
    }
    List<Entry<Character, Integer>> list = 
      new ArrayList<Entry<Character,Integer>>();
    list.addAll(map.entrySet());
    Collections.sort(list, new ByValue());//����, �Ƕ�List���Ͻ�������
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
      new HashSet<Character>();//�����Ե��ַ�����
    ignore.add(' ');
    ignore.add('\t');
    ignore.add('��');
    ignore.add('��');    
    for(int i=0; i<str.length(); i++){
      char ch = str.charAt(i);
      if(ignore.contains(ch)){//�����ַ�����ch�ʹ�����һ��
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

