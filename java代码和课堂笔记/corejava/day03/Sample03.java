package day03;

public class Sample03 {
	public static final int OK = 0;//��������
	public static final String SEX_MALE = "M";
	final int i = 10;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Bean1.i);//iΪ��̬����
		Bean1.f1();//f1Ϊ��̬����
		Bean1 b1 = new Bean1();
		b1.addI();//addIΪ���󷽷�
		b1.addJ();//addJΪ���󷽷�
		System.out.println(Bean1.i);
		System.out.println(b1.j);//jΪ��������
		System.out.println("------------------");
		Bean1 b2 = new Bean1();
		b2.addI();//���󷽷�
		b2.addJ();
		System.out.println(Bean1.i);
		System.out.println(b2.j);//jΪ��������

	}
	
	public void test1(){
		System.out.println(i);
	}


}
