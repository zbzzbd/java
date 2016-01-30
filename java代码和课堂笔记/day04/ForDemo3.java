package basic.day04;
/** 
 EAN-13 条码有效性验证
 
前12位的奇数位的和c1： 　
前12位的偶数位和c2： 　

将"奇数和"与"偶数和的三倍"相加cc = c1+c2*3 
取结果的个位数：(%10)　　

用10减去这个个位数：10 - 8 = 2 　　
所以校验码为2 　　

（注：如果取结果的个位数为0，
那么校验码不是为10 (10 - 0 = 10)，而是0。）

 
 */
public class ForDemo3 {
  public static void main(String[] args) {
    //                0123456789012
    String barcode = "6925303721398";
    //char c = barcode.charAt(1);
    int c1=0;//基数位数字求和
    int c2=0;//偶数位数字求和
    for(int i=0; i<12; i+=2){//i: 0,2,4,6,8,10
      char ch1 = barcode.charAt(i);//'6','2','3'...
      c1+= ch1 - '0';// '6'-'0' = 54-48=6
      char ch2 = barcode.charAt(i+1);//'9','5','0'
      c2+= ch2 - '0';//数字字符减去字符'0'换算为数字
    }
    int cc = c1 + c2 * 3;
    int code = cc%10;//cc%10取个位数
    code = (10-code)%10;//10减去这个码在取个位数
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







