package basic.day03;
/** ������������ת�� */
public class CastDemo {
  public static void main(String[] args) {
    byte b = -128;
    int i = b;//�Զ�����ת��
    System.out.println(i);//-128
    System.out.println(Integer.toBinaryString(i)); 
    i = -129;
    b = (byte)i;//ǿ������ת��
    System.out.println(b);//127
    
    i= 127+1024+512;
    //00000000 00000000 00000110 01111111
    b = (byte)i;
    System.out.println(b); //127
    
    
  }

}
