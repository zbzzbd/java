package day06;
import java.util.*;
public class HashMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<String, Player> table 
			= new HashMap<String, Player>();
		table.put("东", new Player("莫小贝"));
		table.put("南", new Player("貂蝉"));
		table.put("西", new Player("欧阳锋"));
		table.put("北", new Player("小乔"));
		System.out.println(table.containsKey("北"));
		//通过key找到value
		System.out.println(table.get("东"));
		table.put("东", new Player("王菲"));
		System.out.println(table.get("东"));
		//remove之前和之后打印
		System.out.println(table);
		table.remove("东");
		System.out.println(table);
		
		Set keys = table.keySet();
		Collection values= table.values();
		System.out.println(keys);
		System.out.println(values);
		
	}

}
//玩牌的人
class Player{
	String name;
	public Player(String name){
		this.name = name;
	}
	public String toString(){
		return name;
	}
}