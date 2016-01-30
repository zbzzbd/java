package day13;
import java.util.*;

public class TimerDemo {   

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Timer timer = new Timer();
		//�ӳ�0�룬ÿ��1000���룬ִ������(�������ж��������)
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				System.out.println(new Date());
			}
		}, 0, 1000);
		timer.schedule(new TimerTask(){
			@Override
			public void run() {
				timer.cancel();
			}
		}, 5000);
	}

}
