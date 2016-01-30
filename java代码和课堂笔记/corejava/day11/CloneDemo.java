package day11;
import java.io.IOException;
import java.util.*;
public class CloneDemo {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String[] ary1 = {"a", "b", "c"};
		String[] ary2 = ary1;
		System.out.println(ary1 == ary2);//true
		
		//浅复制（克隆）
		String[] ary3 = Arrays.copyOf(ary1, 3);
		System.out.println(ary1 == ary3);//false
		System.out.println(ary1[0] == ary3[0]);//true
		//浅复制，隔离性不好
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person(1, "1234"));
		list.add(new Person(2, "abcd"));
		List<Person> new_list 
			= new ArrayList<Person>(list);
		System.out.println(list == new_list);//false
		System.out.println(list.get(0) == new_list.get(0));//true
		list.get(0).id = 1000;
		System.out.println(new_list.get(0).id);
		//深克隆，性能低，隔离性好
		List<Person> list3 
			= (ArrayList<Person>)IOUtils.clone(list);
		System.out.println(list3.get(0) == list.get(0));//false
		list.get(0).id = 1234;
		System.out.println(list3.get(0).id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
