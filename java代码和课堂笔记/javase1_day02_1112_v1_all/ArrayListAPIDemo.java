package javase1.day02;
import java.util.ArrayList;
public class ArrayListAPIDemo {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    System.out.println("size:"+list.size());
    System.out.println("isEmpty():"+list.isEmpty());
    list.add("����");
    list.add("�ջ�̨");
    list.add("���γ��");
    list.add("����");
    list.add(0, "����");
    System.out.println("size:"+list.size());
    System.out.println("isEmpty():"+list.isEmpty());
    System.out.println(list); 
    list.remove(2);//ɾ���ջ�̨;
    list.remove("����");
    System.out.println(list); 
    System.out.println(list.get(1)); 
    System.out.println(list.contains("����"));//true
  }
}
