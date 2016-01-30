package day06;

//V表示Shop类中的对象属性类型
public class Shop<V> {
	V product; //int i;
	public Shop(V product){
		this.product = product;
	}
	public V buy(double money){
		System.out.println(product.getClass().getName());
		return product; 
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Food f = new Food();
		Shop<Food> foodShop = new Shop<Food>(f);
		System.out.println(foodShop.buy(2));
		
		Pet p = new Pet();
		Shop<Pet> petShop = new Shop<Pet>(p);
		System.out.println(petShop.buy(20));
	}
}

class Food{
	public String toString(){
		return "食物";
	}
}
class Pet{
	public String toString(){
		return "宠物";
	}
}
