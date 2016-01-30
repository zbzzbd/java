package com.tarena.test;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * img.jpg 与 JFrameDemo.class 同一个包内
 *
 */
public class JFrameDemo {
  public static void main(String[] args) {
    //"img.jpg" 是相对路径, 也可以使用绝对路径:
    //如: /com/tarena/test/img.jpg 这个"/"是package的"根"
    URL url = JFrameDemo.class.getResource("img.jpg");
    ImageIcon img = new ImageIcon(url);
    JFrame frame = new JFrame("照片加载");
    JPanel panel = new JPanel();
    JLabel label = new JLabel(img);
    panel.add(label);
    frame.setContentPane(panel);
    frame.setSize(400,300);
    frame.setVisible(true);
  }
}






