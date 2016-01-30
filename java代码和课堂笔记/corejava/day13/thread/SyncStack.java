package day13.thread;

class SyncStack { // ֧�ֶ��߳�ͬ�������Ķ�ջ��ʵ��
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
		System.out.println("������" + c);
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
		System.out.println("����: " + data[index]);
		this.notifyAll();
		return data[index];
	}
}
