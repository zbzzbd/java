package day13.thread;

class Consumer implements Runnable {
	SyncStack stack;

	public Consumer(SyncStack s) {
		stack = s;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			char c = stack.pop();
			// System.out.println("ฯ๛ทั: " + c);
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
			}
		}
	}
}
