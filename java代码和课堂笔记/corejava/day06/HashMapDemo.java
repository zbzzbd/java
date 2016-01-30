package day06;
import java.util.*;
public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Player> table 
			= new HashMap<String, Player>();
		table.put("��", new Player("ĪС��"));
		table.put("��", new Player("����"));
		table.put("��", new Player("ŷ����"));
		table.put("��", new Player("С��"));
		System.out.println(table.containsKey("��"));
		//ͨ��key�ҵ�value
		System.out.println(table.get("��"));
		table.put("��", new Player("����"));
		System.out.println(table.get("��"));
		//remove֮ǰ��֮���ӡ
		System.out.println(table);
		table.remove("��");
		System.out.println(table);
		
		Set keys = table.keySet();
		Collection values= table.values();
		System.out.println(keys);
		System.out.println(values);
		
	}

}
//���Ƶ���
class Player{
	String name;
	public Player(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
}