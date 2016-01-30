package javase1.day02.worm;
/** ���ڵ���� */
public class WormPanel {
  private Worm worm;
  
  private int rows = 15;//����
  private int cols = 40;//����
  
  public WormPanel() {
    worm = new Worm();
  }
  
  public Worm getWorm() {
    return worm;
  }
  
  /** ��ʾ��嵽����̨ */
  public void print(){
    for(int i=0; i<rows; i++){
      for(int j=0;j<cols; j++){
        if(i==0 || i==rows-1){
          System.out.print("-");//������س�!
        }else if(j==0 || j==cols-1){
          System.out.print("|"); 
        }else if(worm.contains(i,j)){
          System.out.print("#");
        }else{
          System.out.print(" ");
        }
      }
      System.out.println();//ÿ�н���������س�
    }
  }
}
