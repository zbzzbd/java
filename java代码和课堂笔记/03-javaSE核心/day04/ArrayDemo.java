package javase1.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDemo {
  public static void main(String[] args) {
    //在集合转换为对象数组时候, 元素对象(Element)复制吗?
    //答: 不复制!, 只是将集合中的元素的引用复制到数组元素
    Set<String> set = new HashSet<String>();
    set.add("Tom");
    set.add("Andy");
    set.add("Jerry");
    set.add("John");
    System.out.println("集合转换为对象数组:");
    Object[] ary = set.toArray();
    //String[] ary2 = (String[])set.toArray();//运行异常
    System.out.println(Arrays.toString(ary));    
    System.out.println("集合转换为指定类型的对象数组:");
    String[] names = {null,null,null,null,null};//
    //将集合中的元素尽可能填充到数组中, 如果数组长度不够返回
    //新数组对象, 新数组长度与集合大小一致
    names = set.toArray(names);
    System.out.println(Arrays.toString(names)); 
    System.out.println(names[0]==ary[0]); 
    
    //Object[] ary3 = (Object[]) set;//错误
    System.out.println("转换数组为集合:Arrays.asList()");
    names = new String[]{"Tom","Jerry","Robin"};
    //asList()返回是一种List的只读实现, 不是ArrayList
    List<String> list = Arrays.asList(names);
    //list.add("Tony");//运行异常, 不支持!
    list = new ArrayList<String>(list); 
    set = new HashSet<String>(list);
    System.out.println(list.get(0)==names[0]);//true
    
    土豆 土豆1 = new 土豆("内蒙古");
    System.out.println(土豆1.你是哪里的()); 
  }
}
class 土豆{
  String 产地;
  public 土豆(String 产地){
    this.产地 = 产地;
  }
  public String 你是哪里的(){
    return  产地;
  }
}




