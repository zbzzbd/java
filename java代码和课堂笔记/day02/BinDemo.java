package basic.day02;

public class BinDemo {
  public static void main(String[] args) {
    int i = 192;
    // 11000000
    //�Զ������ַ�����ʽ�������
    System.out.println(Integer.toBinaryString(i)); 
    System.out.println(Integer.toBinaryString(152)); 
    System.out.println(Integer.toBinaryString(132)); 
    System.out.println(Integer.toBinaryString(-1)); 
    System.out.println(Integer.toBinaryString(-2)); 
    System.out.println(Integer.toBinaryString(-1)); 
    int max = 0x7fffffff;
    System.out.println(Integer.toBinaryString(max));
    System.out.println(Integer.toBinaryString(max+1)); 
    System.out.println(Integer.toBinaryString(~9));//-10
    //������ڴ�ֻ�� �����Ʋ���
    //Ĭ�����, ������ϰ�����10���ƽ��
    //16������, �����Ƶļ�д, 16���Ʊ��ʾ���2����
    //16���ƴ��ڵļ�ֵ: ������д2����!
    int a =0xfffffffe;
    System.out.println(a);//-2
    System.out.println(Integer.toBinaryString(a));
    System.out.println(Integer.toHexString(a));
    int min = 0x80000000;
    //������б߽�����.
    int loan = max;//0x7fffffff
    loan = (loan +1) +(max+1);
    System.out.println(loan);//0
      
         
  }

}




