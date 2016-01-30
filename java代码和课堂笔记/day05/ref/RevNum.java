package basic.day05.ref;
/**
 * 将一个整数数位翻转
     如: 整数 56123 
     返回结果为整数:  32165
     提示: 使用 %10 获取最后一位
           使用 /10 去除处理完的最后一位
 */
public class RevNum {
  public static void main(String[] args) {
    System.out.println(rev(561278));// 872165
  }
  
  public static int rev(int num){
    //num = 561278
    
    //last = num%10;//8
    //val = last;//8
    //num = num/10;//num = 56127
    
    //last = num%10;//7
    //val = val*10+last;//87
    //num = num/10;//num = 5612
    
    //last = num%10;//2
    //val = val*10+last;//872
    //num = num/10;//num = 561

    //last = num%10;//1
    //val = val*10+last;//8721
    //num = num/10;//num = 56

    //last = num%10;//6
    //val = val*10+last;//87216
    //num = num/10;//num = 5

    //last = num%10;//5
    //val = val*10+last;//872165
    //num = num/10;//num = 0
    int val = 0;
    while(true){
      int last = num%10; //val = val*10+num%10
      val = val*10+last; 
      num = num/10; // num/=10;
      if(num==0){// if(num/=10==0)
        break;
      }
    }
    return val;
  }

}
