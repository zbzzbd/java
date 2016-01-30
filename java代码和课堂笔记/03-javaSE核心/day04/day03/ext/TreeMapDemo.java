package javase1.day03.ext;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeMapDemo {
  public static void main(String[] args) {
    TreeSet<Ball> balls = 
      new TreeSet<Ball>(new ByWeight());
    balls.add(new Ball(10));
    balls.add(new Ball(2));
    balls.add(new Ball(1));
    balls.add(new Ball(25));
    balls.add(new Ball(6));//球不能默认比较大小!
    System.out.println(balls);
    //迭代每个球..
    for(Iterator<Ball> i=balls.iterator();i.hasNext();){
      Ball ball = i.next();
      System.out.println(ball); 
    }
    Iterator<Ball> i=balls.iterator();
    while(i.hasNext()){
      Ball ball = i.next();
      System.out.println(ball); 
    }
  }
}
/** 自定义比较器, 实现: 按照某两个球重量比较大小 */
class ByWeight implements Comparator<Ball>{
  public int compare(Ball o1, Ball o2) {
    return o1.weight - o2.weight;
  }
}
class Ball{
  int weight;
  public Ball(int w) {
    weight = w;
  }
  @Override
  public String toString() {
    return "["+weight+"]";
  }
}