package oop.day02;
/**
 * ��һ���й�����! 
 * A ���û�������κι�����, Javac�Զ��ṩĬ�Ϲ�����
 * B ��������˹�����Javac�����ṩĬ�Ϲ�����
 */
public class ConstructorDemo {
  public static void main(String[] args) {
    Foo foo = new Foo();//����Ĭ�Ϲ�����
    //Koo koo = new Koo();//�������, Kooû���޲���������
    Koo k = new Koo(3);//Kooֻ���в���������!
    System.out.println(k.a); //3
  }
}
class Foo{ //Foo����Ĭ�Ϲ�����, ��javac�Զ����
  //public Foo(){};//Ĭ�Ϲ�����
}
class Koo{
  int a;
  public Koo(int a){ //Javac�����ṩĬ�Ϲ�����
    this.a=a;
  }
}

