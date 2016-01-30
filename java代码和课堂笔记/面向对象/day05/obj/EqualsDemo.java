package oop.day05.obj;

public class EqualsDemo {
  public static void main(String[] args) {
    System.out.println("==�ǱȽ�����������ֵ�Ƿ����!");
    int a = 1;
    byte b = 1;
    System.out.println(a==b); //true
    //a = 00000000 00000000 00000000 00000001
    //b = 00000000 00000000 00000000 00000001
    //���ñ�����ֵ�ǵ�ֵַ
    Person p1 = new Person(1);//����,��ַ��: p1=65ff 
    Person p2 = p1;//��ֵ��ֵ(�����Ƶ�ֵַ)�ĸ��� p2=65ff
    System.out.println(p1==p2);//������ֵ�ıȽ� 
    Person p3 = new Person(1);//����,��ַ��: p3=6578 
    System.out.println(p1==p3);//false
    //p1 �� p3 ���õĶ������߼�����ͬһ��
    System.out.println("Object.equals()�������ڱȽ϶���");
    //Ĭ�ϵ�equals()�����ǱȽ϶���ĵ�ַ! ���鸲���޸�!
    //����Ϊ���ݶ����"�ؼ�����"�ж϶����Ƿ����
    System.out.println(p1.equals(p3));//true
    p3 = null;
    System.out.println(p1.equals(p3));//false
    p3 = p1;
    System.out.println(p1.equals(p3));//true
    System.out.println(p1.equals(1));//false
  }
}
class Person{
  int id;
  public Person(int id){
    this.id = id;
  }
  public boolean equals(Object obj) {
    //return this.id == ((Person)obj).id;
    if(obj==null){//��null�Ƚ�
      return false;
    }
    if(this==obj){//ͬһ������, �Է���
      return true;
    }
    if(obj instanceof Person){ //��ͬ���͵ıȽ�
      Person other = (Person)obj;
      return this.id == other.id;
    }
    return false;
  }
  public int hashCode() {
    return id;
  }
}



