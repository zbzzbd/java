package basic.day02;
/** ����������float, double */
public class FloatDemo {
  public static void main(String[] args) {
    //  457278  =  4.57278 * 10^5
    // 10100101010.11 = 1010010101.011 * 2
    // 10100101010.11 = 101001010.1011 * 2^10
    // 10100101010.11 = 10100101.01011 * 2^11    
    // 10100101010.11 = .1010010101011 * 2^1011
    

    //                 β��          ���� ָ��
    //float�Ĵ洢ԭ��, ʵ���Ϸǳ�����
    //float 32λ,  1����  8 λָ�� 23λβ��
    //�洢ԭ��:0 0000 1011 1010 0101 0101 1000 0000 000 
    //IEEE Float 
    int max = 0x7fffffff;//β����31λ
    int a = 0x7ffffff0;//β����31λ
    float f1 = max; //23λβ��
    float f2 = a;  //23λβ��
    System.out.println(f1==f2);//true
    System.out.println(max==a);//false
    //float ���ܾ�ȷ��ʾȫ��int����
    //double 64λ, 1 λ����,11λָ��, 52λβ��
    double d1 = max;
    double d2 = a;
    System.out.println(d1==d2);//false
    System.out.println(d1-d2);//15.0
    //java ��������������Ĭ����double
    double d = 2.6;
    //float f = 2.6;//�������
    float f = 2.6F;//f/F ��׺��float���� ������
    //D/d ��׺��double ����
    // 1 1L 1D 1F 1.0 
    //�����������ǲ�����ȷ��
    double z = d-2d;
    System.out.println(z);//0.6
    //���鲻Ҫ���и������ľ�ȷ�Ƚ�
    System.out.println(z==0.6);//false
    double pi = 3.1415926535897932384626;
    System.out.println(pi); 
 
    
  }
}








