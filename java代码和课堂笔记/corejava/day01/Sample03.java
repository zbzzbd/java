package day01;

public class Sample03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创造一个书对象表示山楂树之恋这本书
		Book book ;
		book = new Book();
		book.no = "ISBN00001";
		book.name = "山楂树之恋";
		book.author = new String[]{"我","你"};
		book.price = 999;
		book.totalPages = 1000;
		System.out.println(book.name);
		//创造一个人对象表示张三
		Person p = new Person();
		p.setName("张三");
		p.setSex("男");
		p.setAge(20);
		p.setName("张二");
		p.setAge(230);
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}
