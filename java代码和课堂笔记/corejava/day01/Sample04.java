package day01;

public class Sample04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Person p = new Person();
		//---��������ʱ���������Ĭ�ϳ�ʼ��---
		System.out.println(p.getName());
		System.out.println(p.getAge());
		Person p1 = new Person();
		p1.setName("jack");
		p1.setSex("��");
		p1.setAge(20);
//		p1 = null;//�������뽫������ָ���쳣
		p = p1;//p1��p��ָ��ͬһ������
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}
