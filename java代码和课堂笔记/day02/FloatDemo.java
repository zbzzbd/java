package basic.day02;
/** ��������ʾ */
public class FloatDemo {
  public static void main(String[] args) {
    int a = 0x7fffffff;
    int b = 0x7ffffff0;
    float f1 = a;
    float f2 = b;
    System.out.println(f1==f2);//true,float���ܾ�ȷ���ȫ��int
    System.out.println(a==b);//false 
    System.out.println(f1);//10����ָ����ʽ���
    System.out.println(f2);
    double d1 = a;
    double d2 = b;
    System.out.println(d1==d2);//false
    System.out.println(d1-d2);//15.0
    
    double x = 2.6;
    System.out.println(x-2);//�����������Ǿ����ܾ�ȷ������
    double d = 3d;// 1 1L 1D 1F
    float f = 2.5f;
  }

}
