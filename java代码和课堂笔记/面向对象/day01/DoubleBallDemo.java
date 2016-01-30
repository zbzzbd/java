package oop.day01;

import java.util.Arrays;
import java.util.Random;

public class DoubleBallDemo {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(gen()));
  }
  public static String[] gen(){
    String[] pool = {"01","02","03","04","05","06","07",
        "08","09","10","11","12","13","14","15","16",
        "17","18","19","20","21","22","23","24","25",
        "26","27","28","29","30","31","32","33"};
    boolean[] used = new boolean[pool.length];
    Random random = new Random();
    String[] balls = new String[6];
    int i=0;
    while(true){
      int index = random.nextInt(pool.length);//[0,33)
      if(used[index]){
        continue;
      }
      balls[i++] = pool[index];
      used[index]=true;
      if(i==balls.length){
        break;
      }
    }
    Arrays.sort(balls);
    balls = Arrays.copyOf(balls, balls.length+1);
    balls[balls.length-1]=pool[random.nextInt(16)];
    return balls;
  }
}
