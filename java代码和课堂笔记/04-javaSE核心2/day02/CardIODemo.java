package javase2.day02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/** Card 扑克牌实例的IO 演示 */
public class CardIODemo {
  public static void main(String[] args) 
    throws IOException {
    //将一副扑克牌存储到文件中, 也就是扑克牌的持久存储.
    List<Card> cards = new ArrayList<Card>();
    for(int rank=Card.THREE; rank<=Card.DEUCE;rank++){
      cards.add(new Card(Card.DIAMOND, rank));
      cards.add(new Card(Card.SPADE, rank));
      cards.add(new Card(Card.HEART, rank));
      cards.add(new Card(Card.CLUB, rank));
    }
    cards.add(new Card(Card.JOKER, Card.BLACK));
    cards.add(new Card(Card.JOKER, Card.COLOR));
    Collections.shuffle(cards);
    String file = "cards.dat";  
    DataOutputStream out = new DataOutputStream(
        new BufferedOutputStream(
            new FileOutputStream(file)));
//    for(Iterator<Card> i=cards.iterator();i.hasNext();){
//      Card card = i.next();
//    }
    for(Card card:cards){
      out.writeInt(card.getSuit());
      out.writeInt(card.getRank());
    }
    out.close();
    System.out.println(cards); 
    IOUtils.print(file);
    // 读取文件cards.dat 到内存的集合中
    //DIS 有readInt()方法
    DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream(file)));
    List<Card> list = new ArrayList<Card>();
    while(true){
      try{
  //    in.readInt() 如果遇到EOF会抛出EOFException
  //    利用这个EOFException 可以检查是否读取结束
        int suit = in.readInt();
        int rank = in.readInt();
        list.add(new Card(suit, rank));
      }catch(EOFException e){
        System.out.println("读取文件结束");
        break;
      }
    }
    in.close();
    System.out.println(cards); 
    System.out.println(list);
    System.out.println(list.equals(cards));//true
    //list 是 cards 的深层复制结果,IO可以变通的实现深层复制
    System.out.println(cards==list);//false
    System.out.println(cards.get(0)==list.get(0));//false
  }
}











