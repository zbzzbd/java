package oop.day04.fnl;
/** final ���εı��� */
public class FinalVarDemo {
  public static void main(String[] args) {
    //final ���εı���, ���Գ�ʼ��, ����ֵ�������޸�
    final int a = 5;
    int b = 5;
    //a++;//�������, a�����ٸ���!
    b++;
    final int[] ary1 = {2,3};
    int[] ary2 = {3,4};
    ary1[0]=8;//����Ԫ�ؿ����޸�
    //ary1 = ary2;//�����, ����ary1��ֵ, �������޸�!
    ary2[0]=8;
    ary2=ary1;
    final Soo s = new Soo();
    s.a = 8;
    //s = null;//�������, ����s��ֵ, �������޸�!
    int x = add(4,5);//x=10
    
  }
  public static int add(final int a, int b){
    //a++;//�������, ����a��ֵ, �������޸�!
    b++;
    return a+b;
  }
}
class Soo{
  int a=2;
  final int b = 5;
}



