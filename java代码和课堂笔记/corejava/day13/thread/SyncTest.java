package day13.thread;

public class SyncTest {
	public static void main(String args[]) {
		SyncStack stack = new SyncStack();
		Runnable p = new Producer(stack);
		Runnable c = new Consumer(stack);
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
	
		t1.start();
		t2.start();

	}
}
