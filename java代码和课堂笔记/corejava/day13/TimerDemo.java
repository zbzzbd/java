package day13;
import java.util.*;

public class TimerDemo {   

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Timer timer = new Timer();
		//延迟0秒，每隔1000毫秒，执行任务(匿名类中定义的任务)
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
