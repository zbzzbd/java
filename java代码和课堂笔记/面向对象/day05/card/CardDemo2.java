package oop.day05.card;

import java.util.Arrays;

public class CardDemo2 {
  public static void main(String[] args) {
    Card c1 = new Card(Card.SPADE, Card.ACE);
    Card c2 = new Card(Card.SPADE, Card.ACE);
    //equals() 经常被Java API 调用, 比较对象是否相等
    //System.out.println(c1.equals(c2));  
    
    Card[] cards = {new Card(Card.JOKER, Card.BLACK), 
        new Card(Card.JOKER, Card.COLOR)};
    Card[] others = {new Card(Card.JOKER, Card.BLACK), 
        new Card(Card.JOKER, Card.COLOR)};
    
    System.out.println(Arrays.equals(cards, others)); 
    
    int a = 15;//  00000000 00000000 00000000 00001111
    int b = a<<1;//0000000 00000000 00000000 000011110
    System.out.println(b); //30
    int c = a<<2;
    int d = 15>>1;
    
    String s1 = new String("abc");
    String s2 = new String("abc");
    String s3 = new String("abcd");
    System.out.println(s1==s2); //false
    System.out.println(s1.equals(s2));//true
    System.out.println(s1.hashCode());
    System.out.println(s2.hashCode());
    System.out.println(s3.hashCode());
    System.out.println("A".hashCode());
    
  }

}
