package javase1.day03.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** 集合迭代的应用: 发扑克牌 */
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
    //洗牌
    Collections.shuffle(cards);
    //发牌(迭代)
    List<Player> players = new LinkedList<Player>();
    players.add(new Player(1, "姜文"));
    players.add(new Player(2, "姜武"));
    players.add(new Player(3, "姜子牙"));
    int i=0;
    Iterator<Card> ite = cards.iterator();
    while(ite.hasNext()){
      Card card = ite.next();
      players.get(i++%players.size()).add(card);
      ite.remove();
      //cards.remove(card);//运行错误, 迭代时候不能操作集合
      if(cards.size()==3){//剩下3张不发了!
        break;
      }
    }
    System.out.println(players.get(0));
    System.out.println(players.get(1));
    System.out.println(players.get(2));
    System.out.println(cards);
  }
}



