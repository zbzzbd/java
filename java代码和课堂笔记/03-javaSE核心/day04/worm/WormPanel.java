package javase1.day04.worm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;

/** 蛇在的面板 */
public class WormPanel {
  private Worm worm;
  
  private int rows = 15;//行数
  private int cols = 40;//列数
  
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
      foods.add(food);//不重复添加!
      if(foods.size()==n){
        break;
      }
    }
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
        }else if(foods.contains(new Node(i,j))){
          System.out.print("0");
        }else{
          System.out.print(" ");
        }
      }
      System.out.println();//每行结束才输出回车
    }
  }
  //类的内部
  public class Worm {
    private LinkedList<Node> nodes = 
      new LinkedList<Node>();
    /** 蛇的当前方向 */
    private int dir;
    
    public static final int RIGHT=1;
    public static final int LEFT=-1;
    public static final int UP=-10;
    public static final int DOWN=10;
    
    public Worm() {
      nodes.add(new Node(3,9));
      nodes.add(new Node(4,9));
      nodes.add(new Node(5,9));
      nodes.add(new Node(5,10));
      nodes.add(new Node(5,11));
      nodes.add(new Node(6,11));
      nodes.add(new Node(7,11));
      dir = RIGHT;
    }
    public LinkedList<Node> getNodes() {
      return nodes;
    }
    
    public void setNodes(LinkedList<Node> nodes) {
      this.nodes = nodes;
    }
    /** 沿着当前方向走一步 */
    public void step(){
      Node head = nodes.getFirst();//nodes.get(0)
      int i = head.getI() + dir/10;
      int j = head.getJ() + dir%10;
      //处理撞墙逻辑, Worm 内部类共享了rows,cols,foods
      if(i==0||i==rows-1 || j==0 || j==cols-1){
        throw new RuntimeException("撞墙了!");
      }
      head = new Node(i,j);
      nodes.addFirst(head);//nodes.add(0, head);
//      if(foods.contains(head)){//检查新蛇头是否在食物集合中
//        foods.remove(head);//删除这个食物
//        return;
//      }
      //处理吃食物的逻辑
      if(foods.remove(head)){//返回true 表示删除成功!
        return;
      }
      nodes.removeLast();//nodes.remove(nodes.size()-1);
    }
    /** 更改方向走一步 */
    public void step(int dir){
      if(this.dir+dir==0){
        throw new RuntimeException("不能掉头走!");
      }
      this.dir = dir;
      step();
    }
    
    public boolean contains(int i, int j){
      return nodes.contains(new Node(i,j));
    }
    
    @Override
    public String toString() {
      return nodes.toString();
    }
    
  }

}




