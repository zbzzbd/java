package oop.day04;

public class FieldDemo {
  public static void main(String[] args){
    Tricker t = new Tricker("John");
    Person p = t;//���Ա��̳�,���԰󶨵�����
    System.out.println(t.name+","+p.name);//John,Tom
    //�����󶨵�����, ���ܱ�����ɶ����, ���ݶ������͵���
    //����ķ���. 
    System.out.println(t.getName()+","+p.getName());//John
  }
}
class Person{
  String name; int age;
  public String getName() { return this.name; }
}/** ƭ�� �� ��, ����Ҳ�������Լ���"����" */
class Tricker extends Person{
  String name;
  public Tricker(String name) {
    this.name = name;
    super.name = "Tom";
  }
  public String getName() { return this.name; }
}

class Student extends Person{
  
}