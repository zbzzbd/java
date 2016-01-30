package day01;

public class Sample04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		//---创建对象时会对属性做默认初始化---
		System.out.println(p.getName());
		System.out.println(p.getAge());
		Person p1 = new Person();
		p1.setName("jack");
		p1.setSex("男");
		p1.setAge(20);
//		p1 = null;//后续代码将发生空指针异常
		p = p1;//p1和p都指向同一个对象
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}
