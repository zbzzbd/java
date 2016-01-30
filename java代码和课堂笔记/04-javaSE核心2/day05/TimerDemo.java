package javase2.day05;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {
  public static void main(String[] args) {
    //Timer: ��ʱ��
    final Timer timer = new Timer();
    //schedule: ʱ��ƻ� 
    //task: ���� 
    timer.schedule(new TimerTask(){
      public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName()+"һ����");
      }
    }, 1000);
    
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_YEAR, 1);
    cal.set(Calendar.HOUR, 7);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    timer.schedule(new TimerTask(){
      public void run() {
        System.out.println("������!"); 
      }
    }, cal.getTime(), 1000L*60*60*24);
    
    final long end = System.currentTimeMillis()+1000*10;
    
    timer.schedule(new TimerTask(){
      public void run() {
        long show = end-System.currentTimeMillis();
        System.out.println(show/1000); 
      }
    }, 0, 1000);
    timer.schedule(new TimerTask(){
      public void run() {
        timer.cancel();
      }
    }, new Date(end));
  }
}





