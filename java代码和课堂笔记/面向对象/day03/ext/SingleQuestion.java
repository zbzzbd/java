package oop.day03.ext;
/** ��ѡ��̳���ѡ����.��ѡ���̳�ѡ��������Ժͷ��� */
public class SingleQuestion extends Question{
  /** Ψһ�ĵ�ѡ��׼�� */
  char answer;
  /** ����һ����ѡ��ʵ��(����),����:���,ѡ���һ����׼�� */
  public SingleQuestion(String text, 
      String[] options, char answer) {
    this.text = text;
    this.options = options;
    this.answer = answer;
  }
  /** ����(��д,���޸�)�����͵ķ���,�ṩ����ļ��𰸵Ĺ��� */
  public boolean check(char[] answers) {
    if(answers==null || answers.length != 1)
      return false;
    return this.answer == answers[0];
  }
}
