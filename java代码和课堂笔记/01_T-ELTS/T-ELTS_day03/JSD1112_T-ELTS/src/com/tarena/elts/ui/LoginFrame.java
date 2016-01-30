package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {
  private static final long serialVersionUID = 7783867897408992323L;
  public LoginFrame() {
    init();
  }
  /** ��ʼ��, ��¼�����е�����Ͳ��� */
  private void init(){
    setTitle("��¼����ϵͳ");
    setSize(300, 220);
    setContentPane(createContentPane());
    setLocationRelativeTo(null);
    this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent e) {
        clientContext.exit(LoginFrame.this);
      }
    });
  }
  private JPanel createContentPane(){
//    Label
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(new EmptyBorder(8,8,8,8));
    p.add(BorderLayout.NORTH, 
        new JLabel("��¼ϵͳ",JLabel.CENTER));
    p.add(BorderLayout.CENTER, createCenterPane());
    p.add(BorderLayout.SOUTH, createBottomPane());
    return p;
  }
  private JPanel createCenterPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.setBorder(new EmptyBorder(10,0,0,0));
    p.add(BorderLayout.NORTH, createIdPwdPane());
    message = new JLabel(
        "", JLabel.CENTER);
    p.add(BorderLayout.CENTER, message);
    return p;
  }
  private JPanel createIdPwdPane(){
    JPanel p = new JPanel(new GridLayout(2,1,0,6));
    p.add(createIdPane());
    p.add(createPwdPane());
    return p;
  }
  private JPanel createIdPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.add(BorderLayout.WEST, new JLabel("���:"));
    JTextField idField = new JTextField();
    this.idField = idField;//****
    p.add(BorderLayout.CENTER, idField);
    return p;
  }
  private JPanel createPwdPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.add(BorderLayout.WEST, new JLabel("����:"));
    JPasswordField pwdField = new JPasswordField();
    this.pwdField = pwdField;//****
    pwdField.enableInputMethods(true);//Linux bug
    p.add(BorderLayout.CENTER, pwdField);
    return p;
  }

  private JPanel createBottomPane(){
    JPanel p = new JPanel(new FlowLayout());
    JButton login = new JButton("��¼");
    JButton cancel = new JButton("ȡ��");
    p.add(login);
    p.add(cancel);
    
    getRootPane().setDefaultButton(login);
    
    login.addActionListener(new ActionListener(){
      //����ť���󱻵��ʱ��, ��ִ�з���actionPerformed()
      //ActionListener����login��ť��ʱ�����
      //ActionEvent e �ǰ�ť�����ʱ��, ������Ϣ(���λ��)
      //������Ǹ�����(�Ǹ���ť)��
      public void actionPerformed(ActionEvent e) {
        //System.out.println("�����Login"+e.getWhen());
        //���ʿ������ṩ�ĵ�¼����, ��ɵ�¼����
        //clientContext.login()����ClientContextʵ��
        clientContext.login();
      }
    });
    
    cancel.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        clientContext.exit(LoginFrame.this); 
      }
    });
    
    return p;
  }
  //........
  /** ClientContext:�ͻ���������,��Ϊ�ͻ��˽�������� */
  ClientContext clientContext;
  public void setClientContext(
      ClientContext clientContext){
    //clientContext��ʵ��ͨ��setClientContext()ע�뵽
    //��ǰ���������this.clientContext��
    //����ע��: IOC
    this.clientContext = clientContext;
  }
  private JTextField idField;
  private JPasswordField pwdField;
  private JLabel message;
  public int getUserId(){
    return Integer.parseInt(idField.getText());
  }
  public String getPwd(){
    return new String(pwdField.getPassword());
  }
  public void showMessage(String message){
    this.message.setText(message);
  }
}










