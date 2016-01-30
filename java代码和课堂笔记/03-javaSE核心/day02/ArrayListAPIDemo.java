package javase1.day02;
import java.util.ArrayList;
public class ArrayListAPIDemo {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    System.out.println("size:"+list.size());
    System.out.println("isEmpty():"+list.isEmpty());
    list.add("ìþìý");
    list.add("¾Õ»¨Ì¨");
    list.add("ÒþÐÎ³á°ò");
    list.add("ìþìý");
    list.add(0, "ÅóÓÑ");
    System.out.println("size:"+list.size());
    System.out.println("isEmpty():"+list.isEmpty());
    System.out.println(list); 
    list.remove(2);//É¾³ý¾Õ»¨Ì¨;
    list.remove("ìþìý");
    System.out.println(list); 
    System.out.println(list.get(1)); 
    System.out.println(list.contains("ìþìý"));//true
  }
}
