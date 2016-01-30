package day07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] names = {"Tom", "Jerry", "Andy",
				"En", "Michael", "Scofield"};
		//Arrays.sort(names);//按照字典顺序排序
		//定义匿名类实现自定义排序原则
		Arrays.sort(names, new Comparator<String>(){
			//自定义排序原则
			public int compare(String name1, String name2) {
				return name1.length() - name2.length();
			}	
		});
		
		for(String name : names){
			System.out.println(name);
		}
		
		ArrayList list = new ArrayList();
		list.add("Scofield");
		list.add("peter");
		list.add("Tom");
		list.add("Jenny");
		list.add("Michael");
		Collections.sort(list, new Comparator<String>(){
			public int compare(String name1, String name2) {
				return name2.length() - name1.length();
			}
			
		});
		System.out.println(list);
		
	}

}
