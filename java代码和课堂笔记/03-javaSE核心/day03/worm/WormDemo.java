package javase1.day03.worm;

import java.util.Scanner;

public class WormDemo {
  public static void main(String[] args) {
    WormPanel pane = new WormPanel();
    //pane.print();
    //Worm worm = new Worm();//Âß¼­´íÎó
    Worm worm = pane.getWorm();
    //worm.step();
   // pane.print();
    Scanner in = new Scanner(System.in);
    while(true){
      pane.print();
      System.out.println(worm);//¸ú×Ùµ÷ÊÔ!
      String cmd = in.nextLine();
      if(cmd.equalsIgnoreCase("u")){
        worm.step(Worm.UP);
      }else if(cmd.equalsIgnoreCase("d")){
        worm.step(Worm.DOWN);
      }else if(cmd.equalsIgnoreCase("r")){
        worm.step(Worm.RIGHT);
      }else if(cmd.equalsIgnoreCase("l")){
        worm.step(Worm.LEFT);
      }else if(cmd.equalsIgnoreCase("q")){
        System.out.println("Ç×, bye!");
      }else{
        worm.step();
      }
      
    }
    
  }

}
