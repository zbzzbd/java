package javase1.day04.inn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CardSortDemo {
  public static void main(String[] args) {
    List<Card> cards = new ArrayList<Card>();
    cards.add(new Card(Card.SPADE, Card.DEUCE));
    cards.add(new Card(Card.HEART, Card.DEUCE));
    cards.add(new Card(Card.CLUB, Card.THREE));
    cards.add(new Card(Card.SPADE, Card.THREE));
    cards.add(new Card(Card.CLUB, Card.EIGHT));
    cards.add(new Card(Card.SPADE, Card.SIX));
    cards.add(new Card(Card.DIAMOND, Card.FIVE));
    Collections.sort(cards, new Comparator<Card>(){
      public int compare(Card o1, Card o2) {
        return -(o1.getRank()-o2.getRank());
      }
    });
    System.out.println(cards); 
  }
}


