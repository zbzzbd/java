package basic.day02;

public class VarDemo {
  public static void main(String[] args) {
    int age;//"����������"int�Ǳ��������ͣ����������� 
    //age�Ǳ�����, ������ʵ������ı�����
    //System.out.println(age);//�������, ����û�г�ʼ��!,
    //��ȡ������ֵ�����.
    age = 12;//"�����ĳ�ʼ��" ���ǵ�һ�θ���
    System.out.println(age);//12
    //int age; //�������, ���������ظ�����
    age = 14;//"�����ĸ�ֵ" �ǵ�һ���Ժ����޸ı�����ֵ
    System.out.println(age);//14
    //System.out.println(score);//�����,û��score
    int score = 100;//��������ͬʱ��ʼ��
    System.out.println(score);//100
    //������������: �������ĵط���ʼ����Ľ���,
    //�����뿪������ͻ���
    if(age<16){
      //int score = 40;//�����. �����ض���!
      int times = 200;
      System.out.println(times); //200
    }
    //System.out.println(times);//�������, û��times
    int times = 100;//û������, �����ض���
    System.out.println(times); //100
  }
}
