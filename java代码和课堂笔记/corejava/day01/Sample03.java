package day01;

public class Sample03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����һ��������ʾɽ���֮���Ȿ��
		Book book ;
		book = new Book();
		book.no = "ISBN00001";
		book.name = "ɽ���֮��";
		book.author = new String[]{"��","��"};
		book.price = 999;
		book.totalPages = 1000;
		System.out.println(book.name);
		//����һ���˶����ʾ����
		Person p = new Person();
		p.setName("����");
		p.setSex("��");
		p.setAge(20);
		p.setName("�Ŷ�");
		p.setAge(230);
		System.out.println(p.getName());
		System.out.println(p.getAge());
	}

}
