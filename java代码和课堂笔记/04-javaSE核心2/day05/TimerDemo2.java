package javase2.day05;

import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo2 {
  public static void main(String[] args) {
    Timer timer = new Timer();
    final char[] chs = "\\|/-".toCharArray();
    timer.schedule(new TimerTask(){
      int index = 0;
      public void run() {
        index++;
        System.out.print(chs[index%chs.length]);
        System.out.print(chs[index%chs.length]);
        System.out.print(chs[index%chs.length]);
        System.out.println(chs[index%chs.length]);
      }
    }, 0, 1000/10);
  }

}
