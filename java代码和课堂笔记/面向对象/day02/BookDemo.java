package oop.day02;

public class BookDemo {
  public static void main(String[] args) {
    Book book;//�������ñ���, book�Ǵ���
    //System.out.println(book.name);//�������,bookû�г�ʼ��
    book = new Book();//new ����,��������
    book.name = "����";
    System.out.println(book.name);
    book = new Book();
    book.name = "�¼����ǵ���";
    System.out.println(book.name);
    /*�����Զ���ʼ��Ϊ"��"ֵ */
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





