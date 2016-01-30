package day11;
import java.io.*;
public class TransientDemo {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Person p = new Person(2, "abcd");
		
		//���л�
		ObjectOutputStream oos 
			= new ObjectOutputStream(
					new FileOutputStream("person.dat"));
		oos.writeObject(p);
		oos.close();
		
		//�����л�
		ObjectInputStream ois
			= new ObjectInputStream(
					new FileInputStream("person.dat"));
		Person p1 = (Person)ois.readObject();
		System.out.println(p1.id + ", " + p1.password);
	}
}

class Person implements Serializable{
	int id;
	transient String password;//˲ʱ���ԣ��������л�
	public Person(int id, String password){
		this.id = id;
		this.password = password;
	}
}
