package basic.day03;
/** �߼�����ͱȽ����� */
public class LogicDemo {
  public static void main(String[] args) {
    //�߼�����: &&(and, ��, ����), ||(����, or), !(��, ��)
    //�Ƚ�����: > >=(���ڵ���) < <=(С�ڵ���), ==(���), !=
    int age = 12;
    char sex = '��';
    boolean isChild = age<16;//�Ƿ���С��
    boolean isMan = sex == '��';
    boolean isBoy = isChild && isMan;//��С���������е�
    boolean isGirl = isChild && ! isMan;
    boolean isKid = isBoy || isGirl;
    System.out.println(isKid); 
    //�Ƕ�·���߼�����: &(�Ƕ�·����) |(�Ƕ�·�Ļ�)
    //��ʮ��������̫̫�������
    age = 66;
    sex = '��';
    //��·����, ����һ�����ʽ������(false), �ڶ����Ͳ��ټ�����
    if(sex=='Ů' && age++>60 ){//��·������
      System.out.println("��̫̫���������, ���!"); 
    }
    System.out.println(age);//66 ˵��: �ڶ������ʽ����·��
  
    age = 66;
    sex = '��';
//  �Ƕ�·����, ����һ�����ʽ������(false), �ڶ���������������
    //��Щ���ϳ���
    if(sex=='Ů' & age++>60 ){//�Ƕ�·������
      System.out.println("��̫̫���������, ���!"); 
    }
    System.out.println(age);//67 ˵��: �ڶ������ʽ��ִ����
   
    //Ů�Ļ�����ͷ���Խ���
    //��·�Ļ� ||, �����һ�����ʽ��true, �ڶ����Ͳ��ټ�����
    age = 28;
    sex = 'Ů';
    if(sex=='Ů' || age++ > 60){
      System.out.println("����, ��ӭ�ι�!"); 
    }
    System.out.println(age);//28
    
    //�Ƕ�·�Ļ� |, ���ܵ�һ�����ʽ�Ƿ�ִ��, ��ִ�еڶ������ʽ.
    age = 28;
    sex = 'Ů';
    if(sex=='Ů' | age++ > 60){
      System.out.println("����, ��ӭ�ι�!"); 
    }
    System.out.println(age);//29
  }
}




