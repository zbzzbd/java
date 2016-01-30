package day11;

import java.io.Serializable;

/**
 * 扑克牌
 * 使用整数表示花色和点数，方便比较大小
 * 0，1，2数字代替3,4,5,...10
 * @author teacher
 *
 */
public class Card implements Serializable{
	public static final int THREE = 0;
	public static final int FOUR = 1;
	public static final int FIVE = 2;
	public static final int SIX = 3;
	public static final int SEVEN = 4;
	public static final int EIGHT = 5;
	public static final int NINE = 6;
	public static final int TEN = 7;
	public static final int JACK = 8;
	public static final int QUEEN = 9;
	public static final int KING = 10;
	public static final int ACE = 11;//A
	public static final int DEUCE = 12;//两点
	public static final int BLACK = 13;//小王
	public static final int COLOR = 14;//大王

	public static final int DIAMONE = 0;//方片
	public static final int CLUB = 1;//梅花
	public static final int HEART = 2;//红心
	public static final int SPADE = 3;//黑桃
	public static final int JOKER = 4;//
	
	public static final String[] SUIT_NAME 
		= {"方片","梅花","红心","黑桃",""};
	public static final String[] RANK_NAME ={
		"3","4","5","6","7","8","9","10","J","Q",
		"K","A","2","大王","小王"};
	private int suit; //花色
	private int rank; //点数
	
	public Card(){
		
	}
	public Card(int suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getSuit() {
		return suit;
	}
	public void setSuit(int suit) {
		this.suit = suit;
	}

	public String toString(){
		//红桃9
		return SUIT_NAME[suit] + RANK_NAME[rank];
	}
	public boolean equals(Object obj){
		if (obj == null) {
			return false;
		}
		if (obj instanceof Card){
			Card card = (Card)obj;
			return this.rank == card.rank
				&& this.suit == card.suit;
		}
		return false;
	}
	
}
