package javase1.day02;
import java.util.ArrayList;
public class ArrayListDemo {
  public static void main(String[] args) {
    StringBuilder buf = new StringBuilder();
    buf.append("��");
    buf.append("��");
    buf.append("��");
    buf.append("��");
    buf.insert(0, "��");
    buf.insert(1, "��");
    System.out.println(buf);
    ArrayList list = new ArrayList();//java.util....
    list.add("��");
    list.add("��");
    list.add("��");
    list.add("��");
    list.add(0, "��");
    list.add(1, "��");
    System.out.println(list);     
  }
}
