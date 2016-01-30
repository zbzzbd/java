package day07;

import java.util.Iterator;

public class AnonymDemo {
	public static void main(String[] args) {
		Book book = new Book("武林外传", new String[]{
				"吕轻侯", "郭芙蓉", "白展堂"
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
		//构造一个Iterator的匿名子类
		return new Iterator(){
			int cursor = -1;//游标
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
