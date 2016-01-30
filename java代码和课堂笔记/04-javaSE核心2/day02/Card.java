package javase2.day02;
/** �˿��� */
public class Card {

  public static final int DIAMOND = 0; //����(��ʯ)
  public final static int CLUB = 1; //÷��
  public static final int HEART = 2; //����(����)
  public static final int SPADE = 3; //����(����)
  public static final int JOKER = 4; //��

  public final static int THREE = 0;
  public final static int FOUR = 1;
  public final static int FIVE = 2;
  public final static int SIX = 3;
  public final static int SEVEN = 4;
  public final static int EIGHT = 5;
  public final static int NINE = 6;
  public final static int TEN = 7;
  public final static int JACK = 8;//J
  public final static int QUEEN = 9;//Q
  public final static int KING = 10;//K
  public final static int ACE = 11;//A
  public final static int DEUCE = 12; //2
  public final static int BLACK = 13; //С��
  public final static int COLOR = 14;//����
  
  /** ��ɫ 0������, 1����÷��, 2�������, 3�������,4:��*/
  private int suit;
  /** ���� �涨: 0����3, 1����4, 2����5,... */
  private int rank;
  public Card() {
  }
  public Card(int suit, int rank){
    //this.rank = rank;
    //this.suit = suit;
    setRank(rank);
    setSuit(suit);
  }
  public int getSuit(){
    return suit;
  }
  public void setSuit(int suit){
    if(suit<DIAMOND || suit>JOKER)
      throw new RuntimeException("��ɫ������Χ!");
    this.suit = suit;
  }
  public int getRank(){
    return rank;
  }
  public void setRank(int rank){
    if(rank<THREE || rank>COLOR){
      throw new RuntimeException("����������Χ!");
    }
    this.rank = rank;
  }
  private static final String[] RANK_NAMES = 
    {"3","4","5","6","7","8","9","10","J","Q","K",
      "A","2","С��","����"};
  private static final String[] SUIT_NAMES = 
    {"����","÷��","����","����",""};
  //����Object ���toStirng() ����. ʵ�ֶ�����ı�����
  public String toString(){
    return SUIT_NAMES[suit]+RANK_NAMES[rank]; 
  }
  
  public boolean equals(Object obj) {
    if(obj==null){
      return false;
    }
    if(this==obj){
      return true;
    }
    if(obj instanceof Card){
      Card other = (Card)obj;
      return this.rank == other.rank &&
             this.suit == other.suit;
    }
    return false;
  }
  
  public int hashCode() {
    //return suit*100+rank;
    //suit=3= 00000000 00000000 00000000 00000011
    //rank=10=00000000 00000000 00000000 00000011
    //suit<<16=00000000 00000011 00000000 00000000
    //         00000000 00000011 00000000 00000011
    return (suit<<16)+rank;//(x<<16)+y
  }
}











