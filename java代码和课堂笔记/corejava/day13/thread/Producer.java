package day13.thread;

import java.util.Random;

class Producer implements Runnable {
	SyncStack stack;

	public Producer(SyncStack s) {
		stack = s;
	}

	public void run() {
		for (int i = 0; i < 20; i++) {
			char c = (char) (Math.random() * 26 + 'A');
			stack.push(c);
			// System.out.println("Éú²ú£º" + c);
			try {
				Thread.sleep(new Random().nextInt(1000));
			} catch (InterruptedException e) {
			}
		}
	}
}
