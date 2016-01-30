package javase1.day05.exp;

public class UncheckExceptionDemo {
  public static void main(String[] args) {
    String str = "八888";
    try{
    //调用了抛出非检查异常(RuntimeException的子类型)的方法
    //Javac 会忽略异常语法检查! 可以捕获处理非检查异常
      int i = Integer.parseInt(str);
    }catch (NumberFormatException e) {
      //处理异常时候建议 打印方法调用堆栈, 方便调试代码
      e.printStackTrace();
     // System.out.println(e.getMessage()); 
      
    }
  }

}
