package javase1.day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayDemo {
  public static void main(String[] args) {
    //�ڼ���ת��Ϊ��������ʱ��, Ԫ�ض���(Element)������?
    //��: ������!, ֻ�ǽ������е�Ԫ�ص����ø��Ƶ�����Ԫ��
    Set<String> set = new HashSet<String>();
    set.add("Tom");
    set.add("Andy");
    set.add("Jerry");
    set.add("John");
    System.out.println("����ת��Ϊ��������:");
    Object[] ary = set.toArray();
    //String[] ary2 = (String[])set.toArray();//�����쳣
    System.out.println(Arrays.toString(ary));    
    System.out.println("����ת��Ϊָ�����͵Ķ�������:");
    String[] names = {null,null,null,null,null};//
    //�������е�Ԫ�ؾ�������䵽������, ������鳤�Ȳ�������
    //���������, �����鳤���뼯�ϴ�Сһ��
    names = set.toArray(names);
    System.out.println(Arrays.toString(names)); 
    System.out.println(names[0]==ary[0]); 
    
    //Object[] ary3 = (Object[]) set;//����
    System.out.println("ת������Ϊ����:Arrays.asList()");
    names = new String[]{"Tom","Jerry","Robin"};
    //asList()������һ��List��ֻ��ʵ��, ����ArrayList
    List<String> list = Arrays.asList(names);
    //list.add("Tony");//�����쳣, ��֧��!
    list = new ArrayList<String>(list); 
    set = new HashSet<String>(list);
    System.out.println(list.get(0)==names[0]);//true
    
    ���� ����1 = new ����("���ɹ�");
    System.out.println(����1.���������()); 
  }
}
class ����{
  String ����;
  public ����(String ����){
    this.���� = ����;
  }
  public String ���������(){
    return  ����;
  }
}




