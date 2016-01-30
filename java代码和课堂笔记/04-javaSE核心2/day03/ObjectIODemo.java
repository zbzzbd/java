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
    //被序列化的对象必须实现Serializable接口!(规定!)
    //writeObject()方法 将foo对象序列化为 byte序列, 写入到
    //outputStream中, 这个Byte序列就是序列化的结果, 
    //这个结果可以使用 ObjectInputStream 的 readObject()
    //方法读取, 反序列化为对象
    out.writeObject(foo);
    String[] ary = new String[]{"1","2"};
    out.writeObject(ary);
    out.close();
    IOUtils.print(file);
    System.out.println("反序列化读取对象:"); 
    ObjectInputStream in = 
      new ObjectInputStream(
          new FileInputStream(file));
    Foo f = (Foo)in.readObject();//反序列化
    String[] ary1=(String[]) in.readObject();
    in.close();
    System.out.println(f.name);//tom
    System.out.println("序列化可以变通的实现对象的深层复制:");
    //对象复制了, 对象属性引用的对象也被复制了!
    System.out.println(f==foo);//false
    System.out.println(f.name == foo.name);//false
    System.out.println(ary==ary1);//false
    //数组元素对象也被复制了
    System.out.println(ary[0] == ary1[0]);//false
  }
}
class Foo implements Serializable{
  int a = 1;
  String name = "Tom";
}


