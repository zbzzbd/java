package javase1.day02;
import java.util.ArrayList;
public class ArrayListDemo {
  public static void main(String[] args) {
    StringBuilder buf = new StringBuilder();
    buf.append("北");
    buf.append("京");
    buf.append("达");
    buf.append("内");
    buf.insert(0, "中");
    buf.insert(1, "国");
    System.out.println(buf);
    ArrayList list = new ArrayList();//java.util....
    list.add("北");
    list.add("京");
    list.add("达");
    list.add("内");
    list.add(0, "中");
    list.add(1, "国");
    System.out.println(list);     
  }
}
