package basic.day04;
/** for ѭ����ʾ */
public class ForDemo {
  public static void main(String[] args) {
    //����10���ڵ�������: 1+3+5+7+9
    int sum = 0;//�ۼӱ���
    
    for(int i=1; i<10; i+=2){//i = i+2
      sum+=i;// sum = sum + i;
    }
    System.out.println(sum); //25
/*   sum   i    i<10
------------------------------------------------------
      0    1    true
      1    3    true
      4    5    true
      9    7    true
     16    9    true
     25    11   false
 */
  }
}










