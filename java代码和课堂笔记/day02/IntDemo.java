package basic.day02;

public class IntDemo {
  public static void main(String[] args){
    int a = 5;//Ĭ����int����
    int b = 0xfffffff4;
    byte c = 5;//
    //byte d = 128;//�������
    //byte d = -129;//�������
    //byte d = 0x80;//�������, 128������
    byte d = 0xffffff80;//��Сֵ -128
    System.out.println(d); //-128
    long max = 0x7fffffffffffffffL;//l/L ��ʾlong������
    //-1 -1L
    long l = -1; //�Զ�����λ��չ����,�Զ�����32��1
    System.out.println(l);//-1
    System.out.println(Long.toBinaryString(l));
    System.out.println(Long.toBinaryString(-1));//�Զ���չ
    byte e = -1;
    System.out.println(Integer.toBinaryString(e));//
  }
}
