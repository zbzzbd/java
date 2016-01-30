package basic.day03;
/** 贷款利率计算 */
public class RetDemo {
  public static void main(String[] args) {
    double ret = 7.8;
    double years = 3;
    double userRet ;
    if(years<=1){
      userRet = ret * 0.8;
    }else if(years<=3){
      userRet = ret * 0.9;
    }else if(years<=5){
      userRet = ret;
    }else if(years<=10){
      userRet = ret * 1.2;
    }else{
      userRet = ret * 1.5;
    }
    System.out.println(userRet);
  }
}
