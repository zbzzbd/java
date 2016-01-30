package day04;

public class Sample04 {
	public static void main(String[] args){
		for(int i=0;i<10;i++){
			Person p = Person.getInstance();
			System.out.println(p);
		}
	}
}
