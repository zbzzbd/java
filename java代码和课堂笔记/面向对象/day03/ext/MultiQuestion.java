package oop.day03.ext;

import java.util.Arrays;

/** ����ѡ����, �̳б�ʾ"��"�Ĺ�ϵ: ��ѡ����ѡ���� */
public class MultiQuestion extends Question {
  /** ��ѡ���׼�� */
  char[] answers;

  public MultiQuestion(String text, 
      String[] options, char[] answers) {
    this.text = text;
    this.options = options;
    this.answers = answers;
  }
  /** ���Ǽ��𰸵ķ���, ʵ�ֶ�ѡ��ľ������û����߼� */
  public boolean check(char[] answers) {
    //answers �����û���, this.answers �����׼��
    return Arrays.equals(answers, this.answers);
  }
}
