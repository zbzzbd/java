package day06;

import java.util.LinkedList;

public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ģ�������ϵĲ���
		Node head = new Node(new Music(1,"����"));
		head.next = new Node(new Music(2, "�໨��"));
		head.next.next = new Node(new Music(3, "������"));
		head.next.next.next = new Node(new Music(4, "����"));
		System.out.println(head);
		
		LinkedList list = new LinkedList();
		list.add(new Music(1, "����"));
		list.add(new Music(2, "�໨��"));
		list.add(new Music(3, "������"));
		list.add(new Music(4, "����"));
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

