package oop.day03.ext;

import java.util.Scanner;

public class PaperDemo {
  public static void main(String[] args) {
    //paper ����, ������ѡ����ļ���(����)
    Question[] paper = {null, null};//new Question[2];
    paper[0]=new SingleQuestion("������Ʊ����?",
        new String[]{"A.�绰","B.����","C.��ţ","D.����"}, 
        'A');
    paper[1]=new MultiQuestion("�Ǽ�λ�Ǵ�����ʦ?",
        new String[]{"A.������","B.������",
                    "C.�����", "D.�����"},
        new char[]{'A','B','C'});
    Scanner console = new Scanner(System.in);
    for(int i=0; i<paper.length; i++){
      Question q = paper[i];
      q.print();//��ӡ����
      System.out.print("��ѡ��:");
      String str = console.nextLine();//�ȴ��û���
      char[] answers = str.toCharArray();//ת����Ϊ����
      //�����Ƕ�̬�󶨵�����, �о���������ִ���Ǹ�����
      if(q.check(answers)){//����û���
        System.out.println("����ѽ!");
      }else{
        System.out.println("��, ҪŬ��ѽ!");
      }
    }    
  }

}
