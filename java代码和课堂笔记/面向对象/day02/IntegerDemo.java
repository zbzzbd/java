package basic.day02;

public class IntegerDemo {
  public static void main(String[] args) {
    int balance = 0x7fffffff;
    balance = balance + 1 + balance + 1;
    //������������Ժ���Ϊ0!Ҫ���ⲹ����������ĸ�����!
    System.out.println(balance);//0
    // 01111111 11111111 11111111 11111111
    //+00000000 00000000 00000000 00000001
    // 10000000 00000000 00000000 00000000
    
    // 01111111 11111111 11111111 11111111
    //+00000000 00000000 00000000 00000001
    // 10000000 00000000 00000000 00000000
    
    //  10000000 00000000 00000000 00000000
    //+ 10000000 00000000 00000000 00000000
    //  00000000 00000000 00000000 00000000
    int max = 0x7fffffff;
    long l = max + 1 + max + 1;
    System.out.println(l);//0
    long l1 = (long)max + (long)1 + max + 1;
    System.out.println(l1);//4G
    
    byte age = 12;//java�ײ�ʹ��int����
    short s = 128;
    //int ʹ�����
    //ֱ�Ӹ�����/ֱ����/������ ������int����
    int a = 5;
    int b = 0xff;
    int c = 010;//�˽���
    //int ���͵����������û�г�����Χ���Ը�С���͸�ֵ
    //byte x = 128;//�����
    byte x = 127;
    byte y = (byte)128;//10000000
    System.out.println(y);//-128
    //��L/lΪ��׺,��ʾlong���͵�������
    long e = 1L;
    //long longMax = 0x7fffffffffffffff;//�����,��������int��Χ 
    long longMax = 0x7fffffffffffffffL; 
     
  }
}







