package basic.day04;

import java.util.Scanner;
/** do while Demo */
public class DoWhileDemo {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in); 
    int balance = 1000;//�������
    int bet;//Ѻע����
    while(true){
      System.out.print("����Ѻע����:");
      bet = console.nextInt();
      if(bet>0 && bet<=balance){//���Ѻע��������ͽ���
        break;//������ǰwhileѭ��
      }
      System.out.println("����!"); 
    }
//    do{
//      System.out.print("����ע:");
//      bet = console.nextInt();//100
////    Ѻע��������0~1000��Χ����������
//    }while(bet<=0 || bet>balance);
    System.out.println(bet); //100
  }
}
//����bet��������: -1, -2,  2000,  100
/* balance  bet  bet<=0  bet>balance  bet<=0||bet>balance
 *  1000    -1    true                     true
 *          -2    true                     true
 *        2000    false     true           true
 *         100    false     false          false
 *               
 * 
 */








