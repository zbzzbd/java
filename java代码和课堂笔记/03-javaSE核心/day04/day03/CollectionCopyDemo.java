package javase1.day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** ���ϵĸ��� */
public class CollectionCopyDemo {
  public static void main(String[] args) {
    ArrayList<String> cards = new ArrayList<String>();
    cards.add("����6"); 
    cards.add("����7"); 
    cards.add("����8"); 
    cards.add("����9");
    ArrayList<String> cards2 = cards;
    cards2.set(2, "����");
    System.out.println(cards);
    System.out.println(cards2); 
    //clone �������� �����"ǳ��"����,����ͬ���͵ļ��ϸ���
    ArrayList<String> copy = 
      (ArrayList<String>)cards.clone();
    copy.set(2, "С��");
    System.out.println(cards);
    System.out.println(copy);
    System.out.println(cards==copy);//false ���ϸ�����
    //����Ԫ�����õĶ���û�и���
    System.out.println(cards.get(0)==copy.get(0));//true
    //Java ��Ĭ�ϵĶ������鸴��Ҳ��ǳ����
    Object[] ary = {1, 2, 3};//�����Զ���װ����
    Object[] ary2 = Arrays.copyOf(ary, ary.length);
    System.out.println(ary==ary2);//false
    System.out.println(ary[0]==ary2[0]);//true
    
    //���ϳ����ĸ���, ʹ�ø��ƹ�����ʵ��
    //���е�Java�����඼�и��ƹ�����, ���ƹ������Ĳ�����
    //�����һ�����϶���, ��Collectionʵ������
    
    Set<String> set = new HashSet<String>(cards);
    System.out.println(set);//����
    
    
    
  }
}







