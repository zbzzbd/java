package oop.day03.ext;
/**
 * �̳��еĹ�����, �﷨�涨:
 * 1 ���������ܼ̳�
 * 2 ��һ��������
 * 3 ���๹����һ�����ø��๹����(���ܼ�ӵ���)
 * 
 * ʹ��super() ���Ե��ø�������
 * ����Ĭ�ϵ��ø���"�޲���������", 
 * ���û���޲���������, ��Ҫʹ��super()��ȷ����ĳ�������� 
 * 
 * ��̽���: �඼�ṩ�޲���������!ʹ��Ĭ�Ϲ���,����������д
 *  */
public class ConstructDemo {
  public static void main(String[] args) {
    Foo foo = new Foo();//���๹����Ĭ�ϵ����˸��๹����
    //ѡ��������: A.������� B.�����쳣 C.�� D.Call Koo()
    //Moo moo = new Moo(6);//�����, ���������ܼ̳�!
    Moo moo = new Moo();
    System.out.println(moo.a);//5
  }
}
class Goo{
  int a;
  public Goo(int a){
    this.a=a;
  }
}
//class Moo extends Goo{}//�������,����û���޲���������
class Moo extends Goo{
  public Moo(){
    //super();//�����,����û���޲���������
    super(5);//���ø����в���������
  }
}
class Koo{
  public Koo(){
    System.out.println("Call Koo()");
  } 
}
class Foo extends Koo{//FooĬ�Ϲ�����������Koo��Ĭ�Ϲ�����
//  public Foo(){
//    super();
//  }
};






