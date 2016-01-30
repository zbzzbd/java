package day12.thread;

public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		T1 t1 = new T1();
		T2 t2 = new T2();
		T3 t3 = new T3();
		Thread t = new Thread(t3);
		t.start();
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		System.out.println("t1的优先级：" + t1.getPriority());
		System.out.println("t2的优先级：" + t2.getPriority());
		System.out.println(Thread.currentThread().getPriority());
		t1.start();//启动线程t1
		t2.start();//启动线程t2
		for(int i = 0 ; i < 100; i++){
			System.out.println("Main:" + i);
		}
	}

}

class T1 extends Thread{
	//线程体
	public void run(){
		for(int i = 0 ; i < 100; i++){
			System.out.println("T1:" + i);
		}
	}
}
class T2 extends Thread{
	public void run(){
		for(int i = 0 ; i < 100; i++){
			System.out.println("T2:" + i);
		}
		
	}
}
class T3 implements Runnable{
	public void run() {
		for(int i = 0 ; i < 100; i++){
			System.out.println("T3:" + i);
		}
	}
	
}


