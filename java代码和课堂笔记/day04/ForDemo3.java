package basic.day04;
/** 
 EAN-13 ������Ч����֤
 
ǰ12λ������λ�ĺ�c1�� ��
ǰ12λ��ż��λ��c2�� ��

��"������"��"ż���͵�����"���cc = c1+c2*3 
ȡ����ĸ�λ����(%10)����

��10��ȥ�����λ����10 - 8 = 2 ����
����У����Ϊ2 ����

��ע�����ȡ����ĸ�λ��Ϊ0��
��ôУ���벻��Ϊ10 (10 - 0 = 10)������0����

 
 */
public class ForDemo3 {
  public static void main(String[] args) {
    //                0123456789012
    String barcode = "6925303721398";
    //char c = barcode.charAt(1);
    int c1=0;//����λ�������
    int c2=0;//ż��λ�������
    for(int i=0; i<12; i+=2){//i: 0,2,4,6,8,10
      char ch1 = barcode.charAt(i);//'6','2','3'...
      c1+= ch1 - '0';// '6'-'0' = 54-48=6
      char ch2 = barcode.charAt(i+1);//'9','5','0'
      c2+= ch2 - '0';//�����ַ���ȥ�ַ�'0'����Ϊ����
    }
    int cc = c1 + c2 * 3;
    int code = cc%10;//cc%10ȡ��λ��
    code = (10-code)%10;//10��ȥ�������ȡ��λ��
    System.out.println(code); //8
    System.out.println(code==barcode.charAt(12)-'0');//true
/* c1  c2  i  i<12  ch1  ch1-'0'  ch2  ch2-'0'
   0   0   0   t    '6'    6      '9'    9
   6   9   2   t    '2'    2     
   8   
   ....
*/ 
  }
}







