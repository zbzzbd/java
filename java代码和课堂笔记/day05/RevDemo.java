package basic.day05;
/** �����ĵݹ���� */
public class RevDemo {
  public static void main(String[] args) {
    // f(n) = 1+2+3+...+n = f(n-1)+n ���� f(1) = 1
    //int y = f(100000);//���д���! ջ�ڴ����
    int y = f(5);
    System.out.println(y);//15
  }
//f(n) = 1+2+3+...+n = f(n-1)+n ���� f(1) = 1
  public static int f(int n){
    if(n==1){
      return 1;
    }
    int y = f(n-1)+n;
    return y;
  }
  
}















