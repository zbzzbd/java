package basic.day03;

import java.util.Scanner;
/** switch case demo */
public class SwitchDemo {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.print("�������:");
    int score = console.nextInt();//�ӿ���̨��ȡ��һ������
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
