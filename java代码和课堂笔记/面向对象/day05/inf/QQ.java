package oop.day05.inf;
/** QQ ��С����, Ҳ����Ʒ, �Ƕ�̳����� 
 * ʵ�ֽӿ�ʹ�ùؼ���: implements ������Ҳ�Ǽ̳й�ϵ
 *  */
public class QQ 
  implements Car, Product {
  public double getPrice() {
    return 29999;
  }
  public String getType() {
    return CLASS_A;//CLASS_A �̳���Car
  }
  public void run() {
    System.out.println("QQ ����!");
  }
  public void stop() {
    System.out.println("QQ ͣ��!");
  }
}
