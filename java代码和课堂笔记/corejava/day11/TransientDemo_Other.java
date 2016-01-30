package day11;
import java.io.*;
public class TransientDemo_Other {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Person p = new Person(2, "abcd");
		
		//序列化
		ByteArrayOutputStream bos 
			= new ByteArrayOutputStream();
		ObjectOutputStream oos 
			= new ObjectOutputStream(bos);
		oos.writeObject(p);
		oos.close();
		
		byte[] array = bos.toByteArray();
		//反序列化
		ByteArrayInputStream bis 
			= new ByteArrayInputStream(array);
		ObjectInputStream ois
			= new ObjectInputStream(bis);
		Person p1 = (Person)ois.readObject();
		System.out.println(p1.id + ", " + p1.password);
	}
}

