package day04;

public abstract class Money {
	protected static final String ZHI_MONEY = "纸币";
	protected static final String JIN_MONEY = "金币";
	protected static final String YIN_MONEY = "银币";
	
	public void show(){
		System.out.println("币种："+getType());
		System.out.println("面额："+getNumber());
	}
	
	public abstract String getType();
	
	public abstract int getNumber();
}
