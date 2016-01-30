package basic.day04;
/** 
 * 打印等额本金还款计划表
 * 等额本金: 每月归还固定数量的本金
 */
public class ForDemo2 {
  public static void main(String[] args) {
    double rate = 7.8/100;//年利率
    int months = 15*12;//还款期数,月份数量
    double loan = 200000;//总贷款金额, 就是本金
    double inc;//利息, 每月支付的利息
    double monthPay = loan/months;//每月支付的本金
    for(int i = 0; i<180; i++){
      inc = (loan - monthPay * i) * (rate/12); 
      System.out.println(
          (i+1)+"期,还款金额:"+(inc+monthPay)+
          ",本金:"+monthPay + ",利息:"+inc);
    }
/* rate  loan   inc     monthPay  i  i<180 
   7.8  200000  1300.0   1111.1   0    t
                1292.7            1    t
   .... 
 */    
  }
}






