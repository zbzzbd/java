package basic.day05;

import java.util.Arrays;

public class SortDemo {
  public static void main(String[] args) {
    int[] ary = { 8, 2, 3, 7, 5 };
    //System.out.println("��ʼ����");
    // selectionSort(ary);
    //bubbleSort(ary);
    insertSort(ary);
    //System.out.println("��������");
    System.out.println(Arrays.toString(ary));
  }
  /** ����ʽ����: �������ÿһ�Ų��뵽ǰ����ʵ�λ�� */
  public static void insertSort(int[] ary){
    int i,j,t;//��������
    for(i=1; i<ary.length; i++){
      t = ary[i];//ȡ������������
      for(j=i-1; j>=0 && t<ary[j]; j--){
        ary[j+1]=ary[j];
      }
//      for(j=i-1; j>=0; j--){//ɨ����Ҳ���λ��
//        if(t<ary[j]){//ǰ��Ԫ�ش���ƶ�Ԫ��
//          ary[j+1]=ary[j];//����ƶ�Ԫ��
//        }else{
//          break;//ǰ��û�д��Ԫ����,���ҵ�����λ��j+1
//        }
//      }
      //����λ�����������,��ͷj=-1,�ҵ�������t��λ��j,����Ҫ+1
      ary[j+1]=t;//����t
    }
  }

  /** ð������: �Ƚ�����Ԫ��,�����󽻻� */
  //������ٵ������, �鿴���ٽ��
  public static void bubbleSort(int[] ary) {
    //System.out.println("Call bubbleSort:"+ Arrays.toString(ary));
    for (int i = 0; i < ary.length - 1; i++) {
      //System.out.println("Run at for:i="+i);
      for (int j = 0; j < ary.length - i - 1; j++) {
        //System.out.println("Run at for:j="+j);
        System.out.print(Arrays.toString(ary) + " ");
        System.out.print(i + " " +j + " ");
        System.out.print(ary[j] + " " +ary[j+1] + " ");
        System.out.print((ary[j] > ary[j + 1]) + " ");
        if (ary[j] > ary[j + 1]) {
          System.out.print(ary[j]+ "<->"+ary[j+1]);
          int t = ary[j];
          ary[j] = ary[j + 1];
          ary[j + 1] = t;
        }
        System.out.println();
      }
    }
  }

  /** ѡ������: ÿ��ѡ��һ����С�Ľ�����ǰ�� */
  public static void selectionSort(int[] ary) {
    for (int i = 0; i < ary.length - 1; i++) {
      for (int j = i + 1; j < ary.length; j++) {
        if (ary[i] > ary[j]) {
          int t = ary[j];
          ary[j] = ary[i];
          ary[i] = t;
        }
      }
    }
  }
}
