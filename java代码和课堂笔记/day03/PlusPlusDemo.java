package basic.day03;
/** ����������ʾ */
public class PlusPlusDemo {
  public static void main(String[] args) {
    int a = 1;
    int b;
    a++;
    ++a;
    System.out.println(a);//3
    a = 1;
    b=a++;
    //����ԭ��: ��ִ��++����, ��ִ�и�ֵ����
    // 1 ��++, ��ȡa��ֵ 1, ��Ϊa++���ʽ��ֵ 1
    // 2 Ȼ��a��ֵ����1, a��Ϊ2
    // 3 ִ�и�ֵ����, ��a++���ʽ��ֵ1 ��ֵ������b
    System.out.println("a:"+a+",b:"+b);//a:2,b:1
    a = 1;
    b = ++a;
    //����ԭ��: ��ִ��++����, ��ִ�и�ֵ����
    // 1 ��++, �Ƚ�a��ֵ����1, a��Ϊ2
    // 2 �ٽ�a��ֵ2��Ϊ���ʽ++a��ֵ
    // 3 �����ʽ++a��ֵ 2 ��ֵ��b
    System.out.println("a:"+a+",b:"+b);//a:2,b:2
    a = 1;
    a = a++;
    a = a++;
    a = a++;
    a = a++;
    // 1 ��++, ��ȡa��ֵ 1, ��Ϊa++���ʽ��ֵ 1
    // 2 Ȼ��a��ֵ����1, a��Ϊ2
    // 3 ִ�и�ֵ����, ��a++���ʽ��ֵ1 ��ֵ������a
    System.out.println("a:"+a);//a:1
    
  }

}
