package day12.thread;

public class DeamonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				for(int i = 0; i < 10000; i++){
					System.out.println("�ػ�" + i + "�Σ�");
				}
			}
		};
		t1.setDaemon(true);//����t1Ϊ�ػ��߳�
		t1.start();
		Thread t2 = new Thread(){
			public void run(){
				for(int i = 0; i < 10; i++){
					System.out.println("ʵ�ֹ��ܣ�" + i);
				}
			}
		};
		t2.start();

	}

}
