package basic.day03;

import java.util.Scanner;

public class WhileDemo2 {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    while(true){
      System.out.print("�������:");
      int score = console.nextInt();
      if(score==-1){
        System.out.println("bye, *_0"); 
        break;//������ǰѭ��
      }
      if(score <0 || score >100){
        System.out.println("�������!");
        continue;//�������ϸ�, ����ѭ���Ŀ�ʼ, �����ȴ�����
      }
      //socre �����ϸ�
      String level;
      switch(score/10){
        case 10: 
        case 9:  level = "����"; break;
        case 8:  level = "����"; break;
        case 7:  level = "�е�"; break;
        case 6:  level = "����"; break;
        default: level = "������";
      }
      System.out.println(level);
    }
  }

}
