package basic.day03;


public class MethodDemo {
  public static void main(String[] args) {
    int x = 5;
    int y = f(x);//�����ĵ���. y=f(x)=3x+2;
    //f=Function, ����
    System.out.println(y);
  }
  /** ����(����)������ */
  public static int f(int x){//����x��y���������ǵ�ǰ����
    int y = 3*x+2;
    return y;//��������˷���ֵ����, �ͱ���ʹ��return����ֵ
  }
}
