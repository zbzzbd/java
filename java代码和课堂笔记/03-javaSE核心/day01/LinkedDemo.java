package javase1.day02;

public class LinkedDemo {
  public static void main(String[] args) {
    Node head = new Node("����");
    head.next = new Node("����");
    head.next.next = new Node("ף��");
    head.next.next.next = new Node("Ƽ��");
    System.out.println(head); 
  }
}
class Node{//����ڵ�
  Object data;
  Node next;
  public Node(Object data){
    this.data = data;
  }
  public String toString() {
    return next==null?data.toString():data+","+next;
  }
}