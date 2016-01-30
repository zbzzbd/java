package oop.day04;

public class FieldDemo {
  public static void main(String[] args){
    Tricker t = new Tricker("John");
    Person p = t;//属性被继承,属性绑定到类型
    System.out.println(t.name+","+p.name);//John,Tom
    //方法绑定到对象, 不管变量是啥类型, 根据对象类型调用
    //对象的方法. 
    System.out.println(t.getName()+","+p.getName());//John
  }
}
class Person{
  String name; int age;
  public String getName() { return this.name; }
}/** 骗子 是 人, 但是也定义了自己的"名字" */
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