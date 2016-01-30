package javase1.day03;
/** 泛型的演示 */
public class ShopDemo {
  public static void main(String[] args) {
    //使用泛型(Pet)约束力商店(Shop)销售商品的类型P
    Shop<Pet> petShop = new Shop<Pet>(new Pet("旺财"));
    Pet dog = petShop.buy();//有"泛型"不需要写"类型转换"
    System.out.println(dog);//旺财
    Shop<Food> foodShop=
      new Shop<Food>(new Food("薯片"));
    Food f = foodShop.buy();
    System.out.println(f);//薯片
    //不使用泛型约束时候, 泛型的默认值是Object
    Shop<Object> shop = new Shop<Object>("东西");
    Shop shop1 = new Shop("东西");
    String s = (String)shop1.buy();
    
  }
}
class Shop<P>{ //通用商店, 销售商品类型在创建时候指定
  P product;
  public Shop(P p) {
    product = p;
  }
  public P buy(){
    return product;
  }
}
class Pet{
  String name;
  public Pet(String name) {
    this.name = name;
  }
  public String toString() {
    return name;
  }
}

class Food{
  String name;
  public Food(String name) {
    this.name = name;
  }
  public String toString() {
    return name;
  }
}




