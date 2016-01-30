package basic.day04;

import java.util.Arrays;

public class CharCounterDemo {
  public static void main(String[] args) {
    String str = "ͳ��һ���ַ����ַ����е�����λ��";
    char key = '��';
    int[] ary =count(str, key);
    System.out.println(Arrays.toString(ary)); 

  }
  public static int[] count(String str, char key){
    //char key = '��';
    //String str = "ͳ��һ���ַ����ַ����е�����λ��";
    int[] count = {}; //new int[0]
    for(int i=0; i<str.length();i++){//�����ַ�����ÿ���ַ�
      char c = str.charAt(i);
      if(c==key){
        //��չ����, 
        count = Arrays.copyOf(count, count.length+1);
        //������ i
        count[count.length-1]=i;
      }
    }
    return count;
  }
}
