package oop.day02;

public class BookDemo {
  public static void main(String[] args) {
    Book book;//声明引用变量, book是代词
    //System.out.println(book.name);//编译错误,book没有初始化
    book = new Book();//new 运算,创建对象
    book.name = "鬼吹灯";
    System.out.println(book.name);
    book = new Book();
    book.name = "致加西亚的信";
    System.out.println(book.name);
    /*属性自动初始化为"零"值 */
    System.out.println(book.price);//0.0
    System.out.println(book.isbn);//null
    book = null;
    System.out.println(book.name);
  }
}/*
public class Book {
  int id;
  String name;
  String[] authors;
  String isbn;
  double price;
}
*/





