package javase2.day01;

public class CPDemo {
  public static void main(String[] args) {
    String file = "d:/myclient.zip";
    String bak = "d:/bak.zip";
    IOUtils.cp(file, bak);
  }

}
