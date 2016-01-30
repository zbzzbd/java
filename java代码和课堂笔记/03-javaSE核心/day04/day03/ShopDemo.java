package javase1.day03;
/** ���͵���ʾ */
public class ShopDemo {
  public static void main(String[] args) {
    //ʹ�÷���(Pet)Լ�����̵�(Shop)������Ʒ������P
    Shop<Pet> petShop = new Shop<Pet>(new Pet("����"));
    Pet dog = petShop.buy();//��"����"����Ҫд"����ת��"
    System.out.println(dog);//����
    Shop<Food> foodShop=
      new Shop<Food>(new Food("��Ƭ"));
    Food f = foodShop.buy();
    System.out.println(f);//��Ƭ
    //��ʹ�÷���Լ��ʱ��, ���͵�Ĭ��ֵ��Object
    Shop<Object> shop = new Shop<Object>("����");
    Shop shop1 = new Shop("����");
    String s = (String)shop1.buy();
    
  }
}
class Shop<P>{ //ͨ���̵�, ������Ʒ�����ڴ���ʱ��ָ��
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




