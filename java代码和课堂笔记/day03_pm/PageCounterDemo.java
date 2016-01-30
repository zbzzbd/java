package basic.day03;

public class PageCounterDemo {
  public static void main(String[] args) {
    //前提条件: 结果行数(28), 每页行数(10)
    //计算结果: 分页数量(3)
    int rows = 28;//行数, row: 行,
    int size = 10;//页面大小
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
