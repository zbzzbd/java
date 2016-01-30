package oop.day04.card;

import java.util.Arrays;
import java.util.Random;

public class CardDemo {
  public static void main(String[] args) {
    //Card card = new Card(3,0);
    //Card c = new Card(Card.SPADE, Card.THREE);
    Card[] cards = new Card[54];
    int i=0;
    for(int rank=Card.THREE; rank<=Card.DEUCE; rank++){
      cards[i++]=new Card(Card.DIAMOND, rank);
      cards[i++]=new Card(Card.HEART, rank);
      cards[i++]=new Card(Card.CLUB, rank);
      cards[i++]=new Card(Card.SPADE, rank);
    }
    cards[i++]=new Card(Card.JOKER, Card.BLACK);
    cards[i++]=new Card(Card.JOKER, Card.COLOR);
    System.out.println(Arrays.toString(cards)); 
    
    //ϴ��(�����㷨) i �������һ�ŵ�λ��, j����ǰ��ĳ�ŵ�λ��
    Random random = new Random();
    for(i=cards.length-1; i>0; i--){
      int j = random.nextInt(i);
      Card t = cards[i];
      cards[i] = cards[j];
      cards[j] = t;
    }
    System.out.println(Arrays.toString(cards)); 
    //����
    Player[] players = new Player[3];
    players[0] = new Player(1, "����");
    players[1] = new Player(2, "���ү");
    players[2] = new Player(3, "������");
    int index=0;
    for(i=0; i<cards.length; i++){
      Card card = cards[i];
      Player someone = players[index++%players.length];
      someone.add(card);
    }
    System.out.println(players[0].toString());
    System.out.println(players[1]);
    System.out.println(players[2]);
  }

}


