package basic.day03;
/** While Demo */
public class WhileDemo {
  public static void main(String[] args) {
    String[] players = {"����","����","��ү��"};
    //                   0      1       2
    //players[2];
    int i=0;
    while(i<54){
      System.out.println(players[i++%3]);
    }
    System.out.println(i);
    
  }

}
