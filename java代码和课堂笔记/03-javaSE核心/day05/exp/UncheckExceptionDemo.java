package javase1.day05.exp;

public class UncheckExceptionDemo {
  public static void main(String[] args) {
    String str = "��888";
    try{
    //�������׳��Ǽ���쳣(RuntimeException��������)�ķ���
    //Javac ������쳣�﷨���! ���Բ�����Ǽ���쳣
      int i = Integer.parseInt(str);
    }catch (NumberFormatException e) {
      //�����쳣ʱ���� ��ӡ�������ö�ջ, ������Դ���
      e.printStackTrace();
     // System.out.println(e.getMessage()); 
      
    }
  }

}
