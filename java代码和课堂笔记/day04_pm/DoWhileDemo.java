package basic.day04;

import java.util.Scanner;
/** do while Demo */
public class DoWhileDemo {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in); 
    int balance = 1000;//筹码余额
    int bet;//押注数量
    while(true){
      System.out.print("输入押注数量:");
      bet = console.nextInt();
      if(bet>0 && bet<=balance){//如果押注数量合理就结束
        break;//结束当前while循环
      }
      System.out.println("错了!"); 
    }
//    do{
//      System.out.print("请下注:");
//      bet = console.nextInt();//100
////    押注数量不在0~1000范围内重新输入
//    }while(bet<=0 || bet>balance);
    System.out.println(bet); //100
  }
}
//假设bet输入序列: -1, -2,  2000,  100
/* balance  bet  bet<=0  bet>balance  bet<=0||bet>balance
 *  1000    -1    true                     true
 *          -2    true                     true
 *        2000    false     true           true
 *         100    false     false          false
 *               
 * 
 */








