package day12.thread;

public class TheadDefineDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//定义Thread的子类
		Thread t1 = new Thread(){
			//线程体
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
