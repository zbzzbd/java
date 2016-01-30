package day02;

public class Person {
	private String name;
	private String sex;
	private int age;
	
	public Person(){}
	
	public Person(String name, String sex, int age) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
	}
	
	public void show(){
		System.out.println("������"+name);
		System.out.println("�Ա�"+sex);
		System.out.println("���䣺"+age);
	}
	
	/**
	 * �����1
	 */
	public void addAge(){
		age++;
	}
	
	/**
	 * ���Ե�ǰ�˶����Ƿ���Ժ�����һ�������
	 * true:��ʾ����,false:��ʾ������
	 * @return
	 */
	public boolean marryWith(Person p){
		//����������Ա�ͬ,����ŮҪ��>20,��Ҫ��>23������
		if(p == null){
			return false;
		}
		//�Ա���ͬ����false
		if(this.sex.equals(p.sex)){
			return false;
		}
		//this������Ա�������С�ڵ���23,����false
		if("��".equals(this.sex) && this.age <=23 ){
			return false;
		}
		//this������Ա�Ů����С�ڵ���20,����false
		if("Ů".equals(this.sex) && this.age <=20 ){
			return false;
		}
		//p������Ա�������С�ڵ���23,����false
		if("��".equals(p.sex) && p.age <=23 ){
			return false;
		}
		//p������Ա�Ů����С�ڵ���20,����false
		if("Ů".equals(p.sex) && p.age <=20 ){
			return false;
		}
		return true;
	}
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
