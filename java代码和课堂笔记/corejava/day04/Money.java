package day04;

public abstract class Money {
	protected static final String ZHI_MONEY = "ֽ��";
	protected static final String JIN_MONEY = "���";
	protected static final String YIN_MONEY = "����";
	
	public void show(){
		System.out.println("���֣�"+getType());
		System.out.println("��"+getNumber());
	}
	
	public abstract String getType();
	
	public abstract int getNumber();
}
