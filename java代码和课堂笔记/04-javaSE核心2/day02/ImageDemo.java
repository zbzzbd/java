package javase2.day02;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** 流的功能扩展 */
public class ImageDemo {
  public static void main(String[] args) 
    throws IOException {
    String file = "src/javase2/day02/img.png";
    InputStream in = new BufferedInputStream(
        new FileInputStream(file));
    BufferedImage img = ImageIO.read(in);
    Graphics2D g = (Graphics2D) img.getGraphics();
    g.setColor(Color.WHITE);
    g.drawString("刘苍松", 50, 50);
    in.close();
    OutputStream out = new BufferedOutputStream(
        new FileOutputStream("img.jpg"));
    ImageIO.write(img, "jpeg", out);
    out.close();
    //显示照片
    JFrame frame = new JFrame("读取照片");
    JPanel panel = new JPanel();
    JLabel label = new JLabel();
    ImageIcon ico = new ImageIcon(img);
    label.setIcon(ico);
    panel.add(label);
    frame.setContentPane(panel);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}









