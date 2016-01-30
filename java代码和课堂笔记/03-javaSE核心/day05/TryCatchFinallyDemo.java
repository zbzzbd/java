package javase1.day05;

public class TryCatchFinallyDemo {
  public static void main(String[] args) {
    System.out.println(test(null)+","+test("55")+","+
        test("")+","+test("9")); 
  }
  public static int test(String s){
    try{
      int i = s.charAt(0)-'0';
      if(i<8){
        throw new Exception("����!");
      }
      return i;
    }catch(NullPointerException e){
      e.printStackTrace();
      return 1;
    }catch(RuntimeException e){//����ʹ�ø����Ͳ���������
      e.printStackTrace();
      return 2;
    }catch(Exception e){
      e.printStackTrace();
      return 3;
    }finally{//�����Ƿ����쳣, ���ǻ�ִ��finally�����
      return 4;
    }
  }
}
