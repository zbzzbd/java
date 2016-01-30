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
    boolean[] used = new boolean[pool.length];//ʹ�ñ��
    Random r = new Random();
    String[] balls = new String[6];//�հ�����
    int i = 0;
    while(true){
      int index = r.nextInt(pool.length);//����±�
      if(used[index])//����±��Ƿ�ʹ�ù�
        continue;//����ִ��ѭ��, �����µ������
      balls[i++]=pool[index];//ȡ��һ���� balls ����
      used[index]=true;//��ʶʹ����
      if(i==balls.length)//����Ƿ�ȡ����
        break;
    }
    Arrays.sort(balls);//�Ժ�������
    balls = Arrays.copyOf(balls, balls.length+1);//��չ����λ��
    balls[balls.length-1] = pool[r.nextInt(16)];//ȡ������
    return balls;
  }
}





