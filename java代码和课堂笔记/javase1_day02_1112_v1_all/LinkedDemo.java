package javase1.day02;

public class LinkedDemo {
  public static void main(String[] args) {
    Node head = new Node("ìþìý");
    head.next = new Node("ÅóÓÑ");
    head.next.next = new Node("×£¸£");
    head.next.next.next = new Node("Æ¼¾Û");
    System.out.println(head); 
  }
}
class Node{//Á´±í½Úµã
  Object data;
  Node next;
  public Node(Object data){
    this.data = data;
  }
  public String toString() {
    return next==null?data.toString():data+","+next;
  }
}