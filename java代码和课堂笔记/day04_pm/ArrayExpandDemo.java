package basic.day04;
import java.util.Arrays;
/** 
 * ������չ����
 * �������ĳ��Ȳ��ܸı�!
 * ��������ĸ��Ʊ���ʵ���������չ
 * 
 */
public class ArrayExpandDemo {
  public static void main(String[] args) {
    String[] songs = {"����","�¹������","ˮ�л�"};
    //����"����֮��"
    String[] temp = Arrays.copyOf(songs, songs.length+1);
    temp[temp.length-1]="����֮��";
    songs = temp;
    System.out.println(Arrays.toString(songs));  
    //������д��
    songs = Arrays.copyOf(songs, songs.length+1);
    songs[songs.length-1] = "����˫˫�Ѽһ�";
    System.out.println(Arrays.toString(songs)); 
  }
}








