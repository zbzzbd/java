package javase1.day03.worm;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/** ���ڵ���� */
public class WormPanel {
  private Worm worm;
  
  private int rows = 15;//����
  private int cols = 40;//����
  
  private Set<Node> foods = 
    new HashSet<Node>();
  
  public WormPanel() {
    worm = new Worm();
    initFoods(5);
  }
  
  private void initFoods(int n){
    Random random = new Random();
    while(true){
      int i = random.nextInt(rows-2)+1;
      int j = random.nextInt(cols-2)+1;
      if(worm.contains(i, j)){
        continue;
      }
      Node food = new Node(i,j);
      foods.add(food);//���ظ����!
      if(foods.size()==n){
        break;
      }
    }
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
        }else if(foods.contains(new Node(i,j))){
          System.out.print("0");
        }else{
          System.out.print(" ");
        }
      }
      System.out.println();//ÿ�н���������س�
    }
  }
}
