package com.tarena.test;

import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * img.jpg �� JFrameDemo.class ͬһ������
 *
 */
public class JFrameDemo {
  public static void main(String[] args) {
    //"img.jpg" �����·��, Ҳ����ʹ�þ���·��:
    //��: /com/tarena/test/img.jpg ���"/"��package��"��"
    URL url = JFrameDemo.class.getResource("img.jpg");
    ImageIcon img = new ImageIcon(url);
    JFrame frame = new JFrame("��Ƭ����");
    JPanel panel = new JPanel();
    JLabel label = new JLabel(img);
    panel.add(label);
    frame.setContentPane(panel);
    frame.setSize(400,300);
    frame.setVisible(true);
  }
}






