package javase1.day02.card;

import java.util.ArrayList;

public class CardDemo {
  public static void main(String[] args) {
    ArrayList cards = new ArrayList();
    cards.add(new Card(Card.SPADE, Card.TEN));
    cards.add(new Card(Card.SPADE, Card.JACK));
    cards.add(new Card(Card.SPADE, Card.QUEEN));
    cards.add(new Card(Card.SPADE, Card.KING));
    cards.add(new Card(Card.SPADE, Card.ACE));
    System.out.println(cards);//Ĭ�ϵ���card.toStirng()
    Card ace = new Card(Card.SPADE, Card.ACE);
    //contains() remove() ��API�ײ�Ĭ�ϵ��ö����equals()
    //�����Ƚ϶���! Card ����equals() �ǳ���Ҫ!
    System.out.println(cards.contains(ace));//true
    
    System.out.println(cards.indexOf(ace)); //4
    
  }
}
