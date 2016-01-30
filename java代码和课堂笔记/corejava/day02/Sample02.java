package day02;

public class Sample02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person("张三","男",25);
//		p.addAge();
//		p = change(p);
//		System.out.println(p.getAge());
		Person p1 = new Person("小月月","女",28);
		System.out.println(p.marryWith(p1));
	}
	
	public static Person change(Person p1){
		p1 = new Person("李四","男",10);
		p1.addAge();
		return p1;
	}
	
	
	
}
