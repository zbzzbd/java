package day04;

public class Person {
	static Person p;
	
	//��չ��췽��
	private Person(){
	}
	
	//�ṩ����Person����ķ���
	public static Person getInstance(){
		//����Person����Ĵ���
		if(p == null){
			p = new Person();
		}
		return p;
	}
	//TODO ҵ�񷽷�
	
}
