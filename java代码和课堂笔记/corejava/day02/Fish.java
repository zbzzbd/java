package day02;

public class Fish extends Animal{
	private int number;//��Ƭ����
	
	//Fish�Ĺ��췽��
	public Fish(String name,String sex,double weight,int number){
		super(name,sex,"��",weight);//����Animal���췽��
		this.number = number;
	}
	
	/**
	 * ��ˮ
	 */
	public void swim(){
		System.out.println("��ˮ���Σ�");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
