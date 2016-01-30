package day06;

import java.util.LinkedList;

public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Ä£ÄâÁ´±í¼¯ºÏµÄ²Ù×÷
		Node head = new Node(new Music(1,"ìþìý"));
		head.next = new Node(new Music(2, "Çà»¨´É"));
		head.next.next = new Node(new Music(3, "ÌðÃÛÃÛ"));
		head.next.next.next = new Node(new Music(4, "ÅóÓÑ"));
		System.out.println(head);
		
		LinkedList list = new LinkedList();
		list.add(new Music(1, "ìþìý"));
		list.add(new Music(2, "Çà»¨´É"));
		list.add(new Music(3, "ÌðÃÛÃÛ"));
		list.add(new Music(4, "ÅóÓÑ"));
		System.out.println(list);
		
	}

}
class Node{
	Object data;
	Node next;
	public Node(Object data){
		this.data = data;
	}
	public String toString(){
/*		String str = "";
		if (next == null){
			str = data.toString();
		}else{
			str = data.toString() 
			+ "->"
			+ next.toString();
		}
		return str;*/
		return (next == null) ? data.toString() :
			data.toString() + "->" + next.toString();
	}
}

