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
		//����,ʹ���ַ�����compareTo�����������ֵ�˳������
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
		personList.add(new Person(1000, "������", 89, 90));
		personList.add(new Person(1001, "���޼�", 78, 25));
		personList.add(new Person(1002, "����", 95, 20));
		System.out.println(personList);
		Collections.sort(personList);
		System.out.println(personList);
		
		//ʹ���Զ���Ƚ��������ַ��������򣩣����ַ�����list����
		//��һ��������Ҫ����ļ��ϣ�
		//�ڶ�������������ԭ��
		//���ݺ�����ԭ��ֿ�
		//CallBack���ص�
		Collections.sort(list, new ByLength());
		System.out.println(list);
		
	}

}
//�Զ����������ʵ��
class Car implements Comparable{
	int id;
	public Car(int id){
		this.id = id;
	}
	public String toString(){
		return Integer.toString(id);
	}
	//�Զ�������ԭ��
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
	//�Զ�������ԭ��
	public int compareTo(Object obj) {
		//return score - ((Person)obj).score;//��score����
		return age - ((Person)obj).age;//��age����
	}
}

//����Ƚ���:�Ƚ�ԭ���ǰ����ַ����ĳ���
class ByLength implements Comparator<String>{

	public int compare(String s1, String s2) {
		return s1.length() - s2.length();
	}
	
}