package javase1.day03;

import java.util.Hashtable;
import java.util.Properties;

public class SystemPropertiesDemo {
  public static void main(String[] args) {
    Properties properties = System.getProperties();
    Hashtable table = properties;
    //properties.list(System.out);
    String os = properties.getProperty("os.name");
    System.out.println(os); 
  }

}
