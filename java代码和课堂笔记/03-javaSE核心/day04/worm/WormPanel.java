package javase1.day04.worm;

import java.util.HashSet;
import java.util.LinkedList;
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
  //����ڲ�
  public class Worm {
    private LinkedList<Node> nodes = 
      new LinkedList<Node>();
    /** �ߵĵ�ǰ���� */
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
    /** ���ŵ�ǰ������һ�� */
    public void step(){
      Node head = nodes.getFirst();//nodes.get(0)
      int i = head.getI() + dir/10;
      int j = head.getJ() + dir%10;
      //����ײǽ�߼�, Worm �ڲ��๲����rows,cols,foods
      if(i==0||i==rows-1 || j==0 || j==cols-1){
        throw new RuntimeException("ײǽ��!");
      }
      head = new Node(i,j);
      nodes.addFirst(head);//nodes.add(0, head);
//      if(foods.contains(head)){//�������ͷ�Ƿ���ʳ�Ｏ����
//        foods.remove(head);//ɾ�����ʳ��
//        return;
//      }
      //�����ʳ����߼�
      if(foods.remove(head)){//����true ��ʾɾ���ɹ�!
        return;
      }
      nodes.removeLast();//nodes.remove(nodes.size()-1);
    }
    /** ���ķ�����һ�� */
    public void step(int dir){
      if(this.dir+dir==0){
        throw new RuntimeException("���ܵ�ͷ��!");
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




