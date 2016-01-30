package javase1.day02.worm;
/** 蛇在的面板 */
public class WormPanel {
  private Worm worm;
  
  private int rows = 15;//行数
  private int cols = 40;//列数
  
  public WormPanel() {
    worm = new Worm();
  }
  
  public Worm getWorm() {
    return worm;
  }
  
  /** 显示面板到控制台 */
  public void print(){
    for(int i=0; i<rows; i++){
      for(int j=0;j<cols; j++){
        if(i==0 || i==rows-1){
          System.out.print("-");//不输出回车!
        }else if(j==0 || j==cols-1){
          System.out.print("|"); 
        }else if(worm.contains(i,j)){
          System.out.print("#");
        }else{
          System.out.print(" ");
        }
      }
      System.out.println();//每行结束才输出回车
    }
  }
}
