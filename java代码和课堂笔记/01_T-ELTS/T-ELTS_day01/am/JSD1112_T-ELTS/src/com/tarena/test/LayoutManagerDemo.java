package com.tarena.test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LayoutManagerDemo {
  public static void main(String[] args) {
    JFrame frame = new JFrame("布局管理测试");
    JPanel content = new JPanel(new BorderLayout());
    JPanel bottom = new JPanel(new BorderLayout());
    JPanel right = new JPanel(new FlowLayout());
    JButton ok = new JButton("OK");
    JButton cancel = new JButton("Cancel");
    right.add(ok);
    right.add(cancel);
    bottom.add(BorderLayout.EAST, right);
    content.add(BorderLayout.SOUTH, bottom);
    frame.setContentPane(content);
    frame.setSize(600, 400);
    frame.setVisible(true);
  }
}
