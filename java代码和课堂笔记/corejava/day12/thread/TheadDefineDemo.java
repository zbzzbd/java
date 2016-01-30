package day12.thread;

public class TheadDefineDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����Thread������
		Thread t1 = new Thread(){
			//�߳���
			public void run(){
				for(int i = 0; i < 100; i++){
					System.out.println("t1:" + i);
				}
			}
		};
		t1.start();
		new Thread(){
			public void run(){
				for(int i = 0; i < 100; i++){
					System.out.println("t2:" + i);
				}
			}
		}.start();
		new Thread(new Runnable(){
			public void run(){
				for(int i = 0; i < 100; i++){
					System.out.println("t3:" + i);
				}
			}
		}).start();

	}

}
