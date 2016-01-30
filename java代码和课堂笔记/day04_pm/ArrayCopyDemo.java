package basic.day04;
import java.util.Arrays;//����Ĺ�����, �������鳣������(����)
/** ����ĸ������� */
public class ArrayCopyDemo {
  public static void main(String[] args) {
    int[] ary1 = {1,2,3};
    int[] ary2 = ary1;
    //ary1��ary2 ��ͬһ������������, û�и�����, 
    //�޸�ary1�ĳ�Ա, �����޸�ary2�ĳ�Ա
    System.out.println("ary1[1]:"+ary1[1]);//2
    System.out.println("ary2[1]:"+ary2[1]);//2
    ary1[1]=5;//
    System.out.println("ary1[1]:"+ary1[1]);//5
    System.out.println("ary2[1]:"+ary2[1]);//5
    int[] ary3 = new int[ary1.length];
    for(int i=0; i<ary1.length; i++){
      ary3[i]=ary1[i];
    }
    ary3[1]=6;
    System.out.println("ary1[1]:"+ary1[1]);//5
    System.out.println("ary3[1]:"+ary3[1]);//6
    
    //Java ϵͳAPI�ṩ�����鸴�ƹ���
    int[] ary4 = new int[ary1.length];
    //   Դ����,��ʼλ��,Ŀ������,Ŀ����ʼλ��,����Ԫ�ظ���
    System.arraycopy(ary1, 0, ary4, 0, ary1.length);
    ary4[1]=8;
    System.out.println("ary1[1]:"+ary1[1]);//5
    //Java 6 �ṩ�˼򻯰�ĸ��Ʋ���, �ײ㻹��arraycopy()
    int[] ary5 = Arrays.copyOf(ary1, ary1.length);
    ary5[1]=10;
    System.out.println("ary1:"+Arrays.toString(ary1));
    //Arrays.toString()������Ԫ������Ϊһ���ַ��� 
    System.out.println("ary5:"+Arrays.toString(ary5));
    System.out.println("ary5:"+ary5);
    //Iterate: �ظ�, ����, �ظ�����
    //"����ĵ���"����, ��������Ԫ�صı�������
    for(int i =0; i<ary5.length; i++){
      int e = ary5[i];
      System.out.println(e);
    }
       
    
  }
}






