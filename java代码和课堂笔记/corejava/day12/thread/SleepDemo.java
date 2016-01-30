package day12.thread;

public class SleepDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t = new Thread(){
			public void run(){
				for (int i = 0; i < 4; i++){
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("±ðµ·ÂÒ£¡");
						//e.printStackTrace();
						break;
					}
					System.out.println("¼ÌÐøË¯¾õ£¡");
				}
			}
		};
		t.start();
		for(int i = 0 ; i < 10; i++){
			System.out.println("ÔÒÇ½£¡ßÛµ±£¡");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("ÔÒÍêÁË£¡");
		t.interrupt();
	}

}
