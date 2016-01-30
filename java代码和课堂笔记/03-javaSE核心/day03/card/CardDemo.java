package javase1.day03.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** ���ϵ�����Ӧ��: ���˿��� */
public class CardDemo {
  public static void main(String[] args) {
    List<Card> cards = new ArrayList<Card>(54);
    for(int rank=Card.THREE; rank<=Card.DEUCE; rank++){
      cards.add(new Card(Card.DIAMOND, rank));
      cards.add(new Card(Card.CLUB, rank));
      cards.add(new Card(Card.HEART, rank));
      cards.add(new Card(Card.SPADE, rank));
    }
    cards.add(new Card(Card.JOKER, Card.BLACK));    
    cards.add(new Card(Card.JOKER, Card.COLOR));    
    //ϴ��
    Collections.shuffle(cards);
    //����(����)
    List<Player> players = new LinkedList<Player>();
    players.add(new Player(1, "����"));
    players.add(new Player(2, "����"));
    players.add(new Player(3, "������"));
    int i=0;
    Iterator<Card> ite = cards.iterator();
    while(ite.hasNext()){
      Card card = ite.next();
      players.get(i++%players.size()).add(card);
      ite.remove();
      //cards.remove(card);//���д���, ����ʱ���ܲ�������
      if(cards.size()==3){//ʣ��3�Ų�����!
        break;
      }
    }
    System.out.println(players.get(0));
    System.out.println(players.get(1));
    System.out.println(players.get(2));
    System.out.println(cards);
  }
}



