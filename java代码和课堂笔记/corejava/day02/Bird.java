package day02;

public class Bird extends Animal{
	private boolean canFly = true;
	
	public Bird(String name,String sex,double weight,boolean canFly){
//		���ø���Animal�Ĺ��췽��
		super(name,sex,"��",weight);
//		this.setName(name);
//		this.setSex(sex);
//		this.setWeight(weight);
//		this.setType("��");
		this.canFly = canFly;
	}
	
	/**
	 * ����
	 */
	public void fly(){
		if(canFly){
			System.out.println("��ѽ�ɣ���ѽ�ɣ�����");
		}else{
			System.out.println("Sorry�����ǲ��񰳲���ɣ�");
		}
	}

	public boolean isCanFly() {
		return canFly;
	}

	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	
}
