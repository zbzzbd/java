package oop.day05.inf;
/** С���� */
public interface Car {
  //�ӿ��е�����Ĭ���ǳ���! ʡ����public static final
  String CLASS_A = "A";//�����ļ���A
  String CLASS_B = "B";
  String CLASS_C = "C";
  /** �ӿ��еķ���һ���ǳ��󷽷�, ʡ��public abstract */
  String getType();//��������ļ���
  
  public abstract void run();
  
  void stop();
}
