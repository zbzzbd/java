package oop.day03;
/** ���������� */
public class MethodDemo {
  public static void main(String[] args) {
    Foo foo = new Foo();
    System.out.println(foo.add(3));
    //Java ���ݷ���ǩ��ʶ�𷽷�, ��"��"����
    System.out.println(foo.add('3'));
    System.out.println(foo.add(3,'3'));
  }
}
class Foo{
  public int add(int x, int y){//add(int,int)
    return x+y;
  }  
  public int add(int x){//add(int)
    return x+1;
  }
  public int add(char x){//add(char)
    return x-'0'+1;
  }
  //public int add(int y){//�������add(int)
  //  return y+1;
 // }
}