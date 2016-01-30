package basic.day03;

import java.util.Scanner;
/** switch case demo */
public class SwitchDemo {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.print("输入分数:");
    int score = console.nextInt();//从控制台读取下一个整数
    String level;
    switch(score/10){
      case 10: 
      case 9:  level = "优秀"; break;
      case 8:  level = "良好"; break;
      case 7:  level = "中等"; break;
      case 6:  level = "及格"; break;
      default: level = "不及格";
    }
    System.out.println(level);
  }
}
