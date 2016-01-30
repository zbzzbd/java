package day06;
import java.util.*;
public class IteratorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list 
			= new ArrayList<String>();
		list.add("°×¼¦µ°");
		list.add("ÏÌÑ¼µ°");
		list.add("ËÉ»¨µ°");
		list.add("ÍÒÄñµ°");
		
/*		Iterator<String> it = list.iterator();
		while(it.hasNext()){
			String egg = it.next();
			System.out.println(egg);
			if (egg.equals("ËÉ»¨µ°")){
				it.remove();
			}
		}*/
		int count = 0;
		for(Iterator it = list.iterator();
			it.hasNext();){
			count++;
			System.out.println(it.next());
		}
		System.out.println(count);
	}

}
