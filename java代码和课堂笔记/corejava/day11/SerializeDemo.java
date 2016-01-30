package day11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
public class SerializeDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) 
		throws FileNotFoundException, IOException, ClassNotFoundException {
//		构造全部的牌
		List<Card> allCards = new ArrayList<Card>();
		for(int rank = Card.THREE; 
			rank <= Card.DEUCE; rank++){
			allCards.add(new Card(Card.DIAMONE, rank));
			allCards.add(new Card(Card.CLUB, rank));
			allCards.add(new Card(Card.HEART, rank));
			allCards.add(new Card(Card.SPADE, rank));
		}
		allCards.add(new Card(Card.JOKER, Card.BLACK));
		allCards.add(new Card(Card.JOKER, Card.COLOR));
		
		Collections.shuffle(allCards);//打乱牌序
		
		//序列化
		ObjectOutputStream oos 
			= new ObjectOutputStream(
					new FileOutputStream("card.dat"));
		oos.writeObject(allCards);
		oos.close();
		System.out.println(allCards);
		
		ObjectInputStream ois
			= new ObjectInputStream(
					new FileInputStream("card.dat"));
		Object obj = ois.readObject();
		List<Card> cards = (List)obj;
		System.out.println(cards);

	}

}
