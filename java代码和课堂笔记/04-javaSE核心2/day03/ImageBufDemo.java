package javase2.day03;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageBufDemo {
  public static void main(String[] args) 
    throws IOException {
    //String file = "my.jpg";
    //OutputStream out = new FileOutputStream(file);
    ByteArrayOutputStream out = 
      new ByteArrayOutputStream();
    BufferedImage img = new BufferedImage(
        100, 50, BufferedImage.TYPE_4BYTE_ABGR);
    String str = "xxgg";//模仿了验证码
    Graphics g = img.getGraphics();
    g.setColor(Color.gray);
    g.drawString(str, 30, 10);
    ImageIO.write(img, "jpg", out);//将img写入到流中
    byte[] buf = out.toByteArray();//获取流中的数据
    ImageIcon ico = new ImageIcon(buf);//显示图片数据
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel(ico);
    panel.add(label);
    frame.setContentPane(panel);
    frame.setSize(200, 100);
    frame.setVisible(true);
    
    
  }
}
