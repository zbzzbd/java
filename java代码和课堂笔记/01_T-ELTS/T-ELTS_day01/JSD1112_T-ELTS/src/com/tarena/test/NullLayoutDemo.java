package com.tarena.test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class NullLayoutDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");
    panel.setLayout(null);//设置布局为null, 自定义管理布局
    ok.setLocation(325, 308);
    ok.setSize(92, 22);
    cancel.setLocation(425,308);
    cancel.setSize(92, 22);
    frame.setSize(533, 373);
    frame.setContentPane(panel);
    panel.add(ok);
    panel.add(cancel);
    frame.setVisible(true);
  }
}





