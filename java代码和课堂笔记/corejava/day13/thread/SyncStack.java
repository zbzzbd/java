package day13.thread;

class SyncStack { // 支持多线程同步操作的堆栈的实现
	private int index = 0;
	private char[] data = new char[26];//26

	public synchronized void push(char c) {
		while (index == data.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		data[index] = c;
		index++;
		System.out.println("生产：" + c);
		this.notifyAll();

	}

	public synchronized char pop() {
		while (index == 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		index--;
		System.out.println("消费: " + data[index]);
		this.notifyAll();
		return data[index];
	}
}
