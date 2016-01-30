package basic.day05.ref;

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
    boolean[] used = new boolean[pool.length];//使用标记
    Random r = new Random();
    String[] balls = new String[6];//空白数组
    int i = 0;
    while(true){
      int index = r.nextInt(pool.length);//随机下标
      if(used[index])//检查下标是否使用过
        continue;//重新执行循环, 生成新的随机数
      balls[i++]=pool[index];//取出一个球到 balls 数组
      used[index]=true;//标识使用了
      if(i==balls.length)//检查是否都取满了
        break;
    }
    Arrays.sort(balls);//对红球排序
    balls = Arrays.copyOf(balls, balls.length+1);//扩展兰球位置
    balls[balls.length-1] = pool[r.nextInt(16)];//取出兰球
    return balls;
  }
}





