package day12.thread;

public class ThreadStateDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		T4 t4 = new T4();
		T5 t5 = new T5();
		Thread t6 = new Thread(new T6());
		t4.start();
		t5.start();
		t6.start();
		System.out.println("Main Over!");
	}

}

class T4 extends Thread{
	//�߳���
	public void run(){
		for(int i = 0 ; i < 1000; i++){
			System.out.println("�õ�������Ҳ�������");
			Thread.yield();
		}
		System.out.println("�����ˣ�");
	}
}
class T5 extends Thread{
	public void run(){
		for(int i = 0 ; i < 100; i++){
			System.out.println("����˭��");
			Thread.yield();
		}
		System.out.println("�����ˣ�");
	}
}
class T6 implements Runnable{
	public void run() {
		for(int i = 0 ; i < 100; i++){
			System.out.println("��ú���ģ�");
			Thread.yield();
		}
		System.out.println("�����ˣ�");
	}
	
}


