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
        throw new Exception("哈哈!");
      }
      return i;
    }catch(NullPointerException e){
      e.printStackTrace();
      return 1;
    }catch(RuntimeException e){//可以使用父类型捕获子类型
      e.printStackTrace();
      return 2;
    }catch(Exception e){
      e.printStackTrace();
      return 3;
    }finally{//不管是否有异常, 总是会执行finally代码块
      return 4;
    }
  }
}
