package basic.day03;

public class PageCounterDemo {
  public static void main(String[] args) {
    //ǰ������: �������(28), ÿҳ����(10)
    //������: ��ҳ����(3)
    int rows = 28;//����, row: ��,
    int size = 10;//ҳ���С
    int pages = rows%size==0 ? rows/size : rows/size+1;
    System.out.println(pages); //3
    
    //28%10 = 8
    //28/10 = 2
    
    // 286%10 = 6
    // 286/10%10=8
    // 286/100 = 2
    
    // 8765 
    
    
  }
}
