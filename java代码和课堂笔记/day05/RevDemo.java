package basic.day05;
/** 方法的递归调用 */
public class RevDemo {
  public static void main(String[] args) {
    // f(n) = 1+2+3+...+n = f(n-1)+n 并且 f(1) = 1
    //int y = f(100000);//运行错误! 栈内存溢出
    int y = f(5);
    System.out.println(y);//15
  }
//f(n) = 1+2+3+...+n = f(n-1)+n 并且 f(1) = 1
  public static int f(int n){
    if(n==1){
      return 1;
    }
    int y = f(n-1)+n;
    return y;
  }
  
}















