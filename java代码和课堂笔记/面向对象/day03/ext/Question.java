package oop.day03.ext;
/** ѡ���� */
public class Question {
  /** ��� */
  String text;
  /** ѡ�� */
  String[] options;
  /** ��ӡ��ǰ��Ŀ */
  public void print(/*Question this*/){
    //this ʵ�����õ��ǵ�ѡ��ʵ��
    System.out.println(this.text);
    for(int i=0;i<this.options.length; i++){
      System.out.print(options[i]+"\t");
    }
    System.out.println(); 
  }
  /** ����, answers �����û���д�Ĵ�
   * ����������� ȷ������ļ��𰸵��߼�, 
   * ��Ҫ�ɾ����͸��Ƿ���*/
  public boolean check(char[] answers){
    return false;//���false��ʾ�û����Ǵ����,Ӧ��
    //���������ṩ����ļ��𰸵ķ���(��"�����ĸ���")
  }
}
