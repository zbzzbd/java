package basic.day04;
/** �����﷨��ʾ */
public class ArrayInitDemo {
  public static void main(String[] args) {
    //�����Ǵ���
    //�����Ǹ���
    //���ʹ����˸���, ����: ���������˶���
    //System.out.println(ary[0]);//�������, û�б���
    int[] ary;//�������������ary, �б���,û���������
    //System.out.println(ary[0]);//�������, ����û�г�ʼ��
//  ������������г�ʼ��
    ary = new int[3];//new int[3] ���������, �Ǹ�"����"
    //��������ԱĬ���Զ���ʼ��Ϊ "��"ֵ:
    // 0, 0.0, \u0000, false, null
    System.out.println(ary[0]);//�������ֳ�Ա(Ԫ��)
    System.out.println(ary[1]);
    System.out.println(ary[2]);
    //����Ԫ���±귶Χ 0~length-1
    //System.out.println(ary[-1]);//�����쳣, ����Խ�����
    //C++ = C Plus Plus = CPP
    int ary1[];//Ϊ����cpp�����ṩ��,��ʵJava�ڲ�û��,��������

    //�������Ķ�̬��ʼ��
    int[] ary3 = new int[4];//���ָ�����鳤��
    //int[] ary4 = new int[];//�������
    int[] ary5 = new int[]{1,2,4,5};//ֱ�Ӹ�������Ԫ��
    
    //�������ľ�̬��ʼ��
    int[] ary6 = {2,3,4,5};//ֻ������,��������ʱ��ֱ�ӳ�ʼ��
    int[] ary7;
    //ary7 = {4,5,6,6};//�������! ��̬��ʼ������������ֵ
    ary7 = new int[]{4,5,6,7};//����ʹ�ö�̬��ʼ��
    
    //����ķ���: []������Զ�д����Ԫ��, .length���Զ�ȡ����
    boolean[] used = new boolean[3];
    //��ȡ����Ԫ��
    System.out.println(used[0]);//false
    System.out.println(used[1]);//false
    System.out.println(used[2]);//false
    System.out.println(used.length);//3
    used[1] = true;//д��(����)����Ԫ��
    System.out.println(used[0]);//false
    System.out.println(used[1]);//true
    System.out.println(used[2]);//false

    used = new boolean[]{true, true};
    System.out.println(used[0]); 
    System.out.println(used[1]); 
    System.out.println(used[2]); 
    //�������, �������, ����Ԫ�� 
    
  }

}





