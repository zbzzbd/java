package day06;
import java.util.*;
public class CollectionsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list = 
			new ArrayList<String>();
		list.add("Tom");
		list.add("Michael Scofield");
		list.add("Jerry");
		list.add("Jenny");
		list.add("Andy");
		list.add("Mac");
		
		System.out.println(list);
		//排序,使用字符串的compareTo方法，即按字典顺序排序
		Collections.sort(list);
		System.out.println(list);

		LinkedList<Car> carList = new LinkedList<Car>();
		carList.add(new Car(2));
		carList.add(new Car(5));
		carList.add(new Car(3));
		System.out.println(carList);
		Collections.sort(carList);
		System.out.println(carList);
		
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(new Person(1000, "张三丰", 89, 90));
		personList.add(new Person(1001, "张无忌", 78, 25));
		personList.add(new Person(1002, "赵敏", 95, 20));
		System.out.println(personList);
		Collections.sort(personList);
		System.out.println(personList);
		
		//使用自定义比较器（按字符长度排序），给字符集合list排序
		//第一个参数：要排序的集合；
		//第二个参数：排序原则
		//数据和排序原则分开
		//CallBack：回调
		Collections.sort(list, new ByLength());
		System.out.println(list);
		
	}

}
//自定义类的排序实现
class Car implements Comparable{
	int id;
	public Car(int id){
		this.id = id;
	}
	public String toString(){
		return Integer.toString(id);
	}
	//自定义排序原则
	public int compareTo(Object obj) {
		Car car = (Car)obj;
		return id - car.id;
	}
}

class Person implements Comparable{
	int id;
	String name;
	int score;
	int age;
	public Person(int id, String name, int score, int age) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
		this.age = age;
	}
	public String toString(){
		return "[" + id + ", " + name + ", " 
		+ score + "," + age + "]";
	}
	//自定义排序原则
	public int compareTo(Object obj) {
		//return score - ((Person)obj).score;//按score排序
		return age - ((Person)obj).age;//按age排序
	}
}

//定义比较器:比较原则是按照字符串的长度
class ByLength implements Comparator<String>{

	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
	
}