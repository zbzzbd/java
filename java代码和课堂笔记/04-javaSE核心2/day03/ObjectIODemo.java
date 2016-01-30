package javase2.day03;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectIODemo {
  public static void main(String[] args)
      throws Exception {
    String file = "obj.dat";
    ObjectOutputStream out = 
      new ObjectOutputStream(
          new BufferedOutputStream(
              new FileOutputStream(file)));
    Foo foo = new Foo();
    //�����л��Ķ������ʵ��Serializable�ӿ�!(�涨!)
    //writeObject()���� ��foo�������л�Ϊ byte����, д�뵽
    //outputStream��, ���Byte���о������л��Ľ��, 
    //����������ʹ�� ObjectInputStream �� readObject()
    //������ȡ, �����л�Ϊ����
    out.writeObject(foo);
    String[] ary = new String[]{"1","2"};
    out.writeObject(ary);
    out.close();
    IOUtils.print(file);
    System.out.println("�����л���ȡ����:"); 
    ObjectInputStream in = 
      new ObjectInputStream(
          new FileInputStream(file));
    Foo f = (Foo)in.readObject();//�����л�
    String[] ary1=(String[]) in.readObject();
    in.close();
    System.out.println(f.name);//tom
    System.out.println("���л����Ա�ͨ��ʵ�ֶ������㸴��:");
    //��������, �����������õĶ���Ҳ��������!
    System.out.println(f==foo);//false
    System.out.println(f.name == foo.name);//false
    System.out.println(ary==ary1);//false
    //����Ԫ�ض���Ҳ��������
    System.out.println(ary[0] == ary1[0]);//false
  }
}
class Foo implements Serializable{
  int a = 1;
  String name = "Tom";
}


