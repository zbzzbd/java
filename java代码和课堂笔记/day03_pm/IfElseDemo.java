package basic.day03;

/**
 * 
 **/
public class IfElseDemo {
  public static void main(String[] args) {
    //µÚ¶þ±­°ë¼Û
    int qty = 5;//5±­
    double price = 5;
    double pay = price;
    if (qty >= 2) {
      pay += price / 2 * (qty - 1);
      // pay = pay + price/2*(qty-1);
    }
    //    double pay;
    //    if(qty>=2){
    //      pay = price + price/2*(qty-1);
    //    }else{
    //      pay = price;
    //    }
    System.out.println(pay);

  }

}
