package basic.day04;
/** 
 * ��ӡ�ȶ�𻹿�ƻ���
 * �ȶ��: ÿ�¹黹�̶������ı���
 */
public class ForDemo2 {
  public static void main(String[] args) {
    double rate = 7.8/100;//������
    int months = 15*12;//��������,�·�����
    double loan = 200000;//�ܴ�����, ���Ǳ���
    double inc;//��Ϣ, ÿ��֧������Ϣ
    double monthPay = loan/months;//ÿ��֧���ı���
    for(int i = 0; i<180; i++){
      inc = (loan - monthPay * i) * (rate/12); 
      System.out.println(
          (i+1)+"��,������:"+(inc+monthPay)+
          ",����:"+monthPay + ",��Ϣ:"+inc);
    }
/* rate  loan   inc     monthPay  i  i<180 
   7.8  200000  1300.0   1111.1   0    t
                1292.7            1    t
   .... 
 */    
  }
}






