package basic.day03;

import java.util.Scanner;

public class WhileDemo2 {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    while(true){
      System.out.print("输入分数:");
      int score = console.nextInt();
      if(score==-1){
        System.out.println("bye, *_0"); 
        break;//结束当前循环
      }
      if(score <0 || score >100){
        System.out.println("输入错误!");
        continue;//分数不合格, 返回循环的开始, 继续等待输入
      }
      //socre 分数合格
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

}
