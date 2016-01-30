package day07;

import java.util.Iterator;

public class AnonymDemo {
	public static void main(String[] args) {
		Book book = new Book("�����⴫", new String[]{
				"�����", "��ܽ��", "��չ��"
		});
		Iterator<String> it = book.authors();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}

class Book{
	String name;
	String [] authors;
	public Book(String name, String[] authors){
		this.name = name;
		this.authors = authors;
	}
	public Iterator authors(){
		//����һ��Iterator����������
		return new Iterator(){
			int cursor = -1;//�α�
			public boolean hasNext() {
				return cursor + 1 < authors.length;
			}
			public Object next() {
				return authors[++cursor];
			}
			public void remove() {
			}
		};
	}
}
