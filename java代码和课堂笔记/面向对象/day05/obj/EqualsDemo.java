package oop.day05.obj;

public class EqualsDemo {
  public static void main(String[] args) {
    System.out.println("==是比较两个变量的值是否相等!");
    int a = 1;
    byte b = 1;
    System.out.println(a==b); //true
    //a = 00000000 00000000 00000000 00000001
    //b = 00000000 00000000 00000000 00000001
    //引用变量的值是地址值
    Person p1 = new Person(1);//假如,地址是: p1=65ff 
    Person p2 = p1;//赋值是值(二进制地址值)的复制 p2=65ff
    System.out.println(p1==p2);//二进制值的比较 
    Person p3 = new Person(1);//假如,地址是: p3=6578 
    System.out.println(p1==p3);//false
    //p1 和 p3 引用的对象在逻辑上是同一个
    System.out.println("Object.equals()方法用于比较对象");
    //默认的equals()方法是比较对象的地址! 建议覆盖修改!
    //覆盖为根据对象的"关键属性"判断对象是否相等
    System.out.println(p1.equals(p3));//true
    p3 = null;
    System.out.println(p1.equals(p3));//false
    p3 = p1;
    System.out.println(p1.equals(p3));//true
    System.out.println(p1.equals(1));//false
  }
}
class Person{
  int id;
  public Person(int id){
    this.id = id;
  }
  public boolean equals(Object obj) {
    //return this.id == ((Person)obj).id;
    if(obj==null){//与null比较
      return false;
    }
    if(this==obj){//同一个对象, 自反性
      return true;
    }
    if(obj instanceof Person){ //相同类型的比较
      Person other = (Person)obj;
      return this.id == other.id;
    }
    return false;
  }
  public int hashCode() {
    return id;
  }
}



