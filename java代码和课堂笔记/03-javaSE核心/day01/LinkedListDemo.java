package javase1.day02;
import java.util.LinkedList;
public class LinkedListDemo {
  public static void main(String[] args) {
    //LinkedList: 是用双向循环链表实现的List(线性表)结构
    // LinkedList: 链表存储结构 + 链表的操作(增删改查)
    // ArrayList: Object[]存储结构+数组操作(增删改查)
    // ArrayList: 采用数组存储, 按照index检索速度非常快
    //            顺序(indexOf)查询慢, 插入慢(需要移动)
    // LinkedList: 采用链表存储, 头尾插入删除非常快
    // 工作中大多使用: ArrayList! 
    // Vector: 也是 Object[]存储结构+数组操作(增删改查)
    
    // ArrayList: Java 1.2 以后, 性能好 非线程安全
    // Vector: 早期java 1.1 性能稍差 线程安全
    
    
    LinkedList list = new LinkedList();
    list.add("忐忑");
    list.add("朋友");
    list.add("萍聚");
    list.add("忐忑");
    list.add(0, "隐形翅膀");
    System.out.println(list); 
  }
}
