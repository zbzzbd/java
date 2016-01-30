package basic.day02;

import java.util.Random;

/** �ַ����͵���ʾ */
public class CharDemo {
  public static void main(String[] args) {
    char c = 20013;//�ַ���һ����
    System.out.println(c);//��, Java �����˵�ϰ������ַ�
    System.out.println((int)c);//20013
    System.out.println(Integer.toBinaryString((int)c)); 
    System.out.println(Integer.toHexString((int)c)); 
    c = 65;
    System.out.println(c);//A
    c = 0x4e2d;
    System.out.println(c);//��
    
    System.out.println(Integer.toHexString('��')); 
    System.out.println("�ַ�A-Z�ı���"); 
    System.out.println((int)'A'); 
    System.out.println((int)'B'); 
    System.out.println((int)'C'); 
    System.out.println((int)'D'); 
    System.out.println((int)'E'); 
    System.out.println("�ַ�0-9�ı���"); 
    System.out.println((int)'0'); //48
    System.out.println((int)'1'); //49
    System.out.println((int)'2'); //50
    System.out.println((int)'3'); //51
    System.out.println((int)'4'); //52
    System.out.println((int)'5'); //53

    int n = '5'-'0';//n=53-48=5  '6'-'0'
    System.out.println(n);//5
    //�����ַ�, ת��Ϊ����, ch-'0'
    char ch = '9';
    int num = ch - '0';
    System.out.println(num);//9
    
    ch = 'A'+2;
    System.out.println(ch);//'C'
    
    Random random = new Random();
    int index = random.nextInt(26);//���������:[0,26)
    ch = (char)(index+'A');
    System.out.println(ch);//'A'~'Z' 
    
  }

}
