package javase1.day03;

import java.util.ArrayList;
import java.util.List;

/** ��װ��  */
public class WorpClassDemo {
  public static void main(String[] args) {
    //��������û�и�����, ���̳�Object
    //Java�ṩ��װ��,���������Ͱ�װΪ����,�����"��Ҳ�Ƕ���"
    //Java ��������: int, Integer ��������
    // ��װ���͵� ���Ƕ����ڶ���
    Integer i = new Integer(5);//i ���ö��� "5"
    //Java �а��ְ�װ��, ��Ӧ8�л�������
    Double d = new Double(6.6);
    
    //��װ���ṩ��"������������������������":
    //���ܹ�ʶ��������:String ��: "30"
    //������ܹ�����������Ƕ�����(����): 00011110
    //��װ�ṩ�˽� "30"ת��Ϊ����������(int)�ķ���
    int x = Integer.parseInt("30");
    int y = Integer.parseInt("f", 16);
    // console.nextInt() �����ĵײ������ parseInt()
    double dx = Double.parseDouble("5.5");
    
    //��װ�໹�ṩ�˽�����������ת��Ϊ ���ܹ�������String����
    x = 0xffffffff;
    System.out.println(x);//-1 
    System.out.println(Integer.toString(x)); 
    dx = 6.5;
    System.out.println(Double.toString(dx));  
    
    //Java 5 �ṩ���Զ���װ/�������:
    Integer j = 5;//new Integer(5); 
    Boolean b = true;
    Object o = 5.5;//new Double(5.5)
    Number n = 6;//new Integer(6)
    Double s = (Double)o;
    //�Զ����
    int k = j+1;//k = j.intValue() + 1
    j = j + 1;// j = new Integer(j.intValue()+1)
    k = k+1;
    
    List<Integer> list = new ArrayList<Integer>();
    list.add(1);
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(5);
    list.add(8);
    list.add(13);
    System.out.println(list); 
    int f = list.get(3);
    System.out.println(f);  
   
    Integer aa = new Integer(1);
    Integer bb = new Integer(1);
    System.out.println(aa==bb);//false
    System.out.println(aa.equals(bb));//true
       
    Integer cc = 1;
    Integer dd = 1;
    System.out.println(cc==dd);//true
    
    
  }
}
