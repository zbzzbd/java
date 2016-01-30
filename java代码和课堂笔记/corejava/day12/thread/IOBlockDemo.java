package day12.thread;
import java.io.*;
public class IOBlockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final BufferedReader br 
			= new BufferedReader(
					new InputStreamReader(System.in));
		new Thread(){
			public void run(){
				while(true)
					try {
						//br.readLine()�����¼���������ǰ���߳�
						//ʹ��ǰ�߳̽���Block״̬
						//ֱ��IO����(�س�)��Block->Runnable״̬
						String line = br.readLine();
						System.out.println("�յ�һ�������ˣ�" + line);
						if("exit".equals(line)){
							break;
						}						
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

		}.start();
		new Thread(){
			public void run(){
				for (int i = 0; i < 100; i++){
					System.out.println("���ҵģ�");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
