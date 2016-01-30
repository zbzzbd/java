package day12.thread;

public class DeamonDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(){
			public void run(){
				for(int i = 0; i < 10000; i++){
					System.out.println("守护" + i + "次！");
				}
			}
		};
		t1.setDaemon(true);//设置t1为守护线程
		t1.start();
		Thread t2 = new Thread(){
			public void run(){
				for(int i = 0; i < 10; i++){
					System.out.println("实现功能！" + i);
				}
			}
		};
		t2.start();

	}

}
