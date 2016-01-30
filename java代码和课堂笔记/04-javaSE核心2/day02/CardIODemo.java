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

/** Card �˿���ʵ����IO ��ʾ */
public class CardIODemo {
  public static void main(String[] args) 
    throws IOException {
    //��һ���˿��ƴ洢���ļ���, Ҳ�����˿��Ƶĳ־ô洢.
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
    // ��ȡ�ļ�cards.dat ���ڴ�ļ�����
    //DIS ��readInt()����
    DataInputStream in = new DataInputStream(
        new BufferedInputStream(
            new FileInputStream(file)));
    List<Card> list = new ArrayList<Card>();
    while(true){
      try{
  //    in.readInt() �������EOF���׳�EOFException
  //    �������EOFException ���Լ���Ƿ��ȡ����
        int suit = in.readInt();
        int rank = in.readInt();
        list.add(new Card(suit, rank));
      }catch(EOFException e){
        System.out.println("��ȡ�ļ�����");
        break;
      }
    }
    in.close();
    System.out.println(cards); 
    System.out.println(list);
    System.out.println(list.equals(cards));//true
    //list �� cards ����㸴�ƽ��,IO���Ա�ͨ��ʵ����㸴��
    System.out.println(cards==list);//false
    System.out.println(cards.get(0)==list.get(0));//false
  }
}











