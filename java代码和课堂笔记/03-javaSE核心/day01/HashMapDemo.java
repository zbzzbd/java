package javase1.day02;
import java.util.HashMap;
 

public class HashMapDemo {
  public static void main(String[] args) {
    //散列表的key是人名String类型, value 是人Person类型  
    HashMap<String, Person> hotel = 
      new HashMap<String, Person>();
    hotel.put("Tom", new Person(1, "Tom", 15));
    hotel.put("Jerry", new Person(2, "Jerry", 16));
    hotel.put("Andy", new Person(3, "Andy", 8));
    hotel.put("John", new Person(4, "John", 17));
    hotel.put("Tom", new Person(5, "Tom", 18));
    System.out.println(hotel); 
    Person tom = hotel.get("Tom");
    System.out.println(tom.age); 
    System.out.println(hotel.entrySet());//返回所有key:value
    System.out.println(hotel.keySet());//返回所有key
    System.out.println(hotel.values());//返回所有Value
  }
}
class Person{
  int id;
  String name;
  int age;
  public Person(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }
  @Override
  public String toString() {
    return "["+id+","+name+","+age+"]";
  }
  @Override
  public boolean equals(Object obj) {
    if(obj==null)
      return false;
    if(this==obj)
      return true;
    if (obj instanceof Person) {
      Person o = (Person) obj;
      return this.id==o.id;
    }
    return false;
  }
  @Override
  public int hashCode() {
    return id;
  }
  
}