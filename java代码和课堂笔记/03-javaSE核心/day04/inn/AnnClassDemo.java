package javase1.day04.inn;

import java.util.Arrays;
import java.util.Comparator;

/** �����ڲ�����ʾ, ������ */
public class AnnClassDemo {
  public static void main(String[] args) {
    //new Koo(){} �����ڲ���! �Ǽ̳���Koo��ͬʱ�����������
    //û������, ����Ƕ���, ������Koo������. ����{} �������
    //����(class body) �����п���������ĳ�Ա(����,����)
    Koo koo = new Koo(){
      public String toString(){
        return "������";
      }
    };
    Koo k1 = new Koo();
    System.out.println(koo + ", " + k1); 
    //֤����kooʵ���гɹ��ĸ�����toString();
    //��������Լ̳���: �� ������ �� �ӿ�
    //�̳��� ������ �� �ӿ� ʱ��Ҫʵ��ȫ���ĳ��󷽷�!
    //Moo m1 = new Moo();//�������, ���ܴ���������ʵ��
    Moo m2 = new Moo(){};//û�д���, ����ֱ�Ӵ���������ʵ��
    //new Moo(){}��������, �Ǽ̳���Moo������,��ͬʱ����ʵ��
    //Xoo xoo = new Xoo(){};//�������, û��ʵ�ֳ��󷽷�
    Xoo xoo = new Xoo(){
      int add() {//ʵ�ָ���ĳ��󷽷�
        return 1+1;
      }
    };
    System.out.println(xoo.add());//2,��̬�󶨵����󷽷�
    
    final int a = 4;
    Yoo yoo = new Yoo(){ //�������������ʵ�ֽӿ�
      int c = 8;
      public int add(int c) {
        return a+c+this.c; //��������Է���final�ֲ�����, 
      }
    };
    System.out.println(yoo.add(5));//17 
    //System.out.println(yoo.c);//�����,Yoo����û��c����!
    final int dir = -1;
    String[] names = {"Tom", "Jerry","Tony Wang","QQ"};
    Comparator<String> byLength = 
      new Comparator<String>(){
      public int compare(String o1, String o2) {
        return dir * (o1.length()-o2.length());
      }
    };
    Arrays.sort(names, byLength);
    System.out.println(Arrays.toString(names));  
    
    Arrays.sort(names, new Comparator<String>(){
      public int compare(String o1, String o2) {
        return o1.length()-o2.length();
      }
    });
    System.out.println(Arrays.toString(names)); 
  }
}
interface Yoo{
  int add(int c);
}
abstract class Xoo{
  abstract int add();
}
abstract class Moo{
}

class Koo{
}

