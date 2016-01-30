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
  /** 初始化, 登录窗口中的组件和布局 */
  private void init(){
    setTitle("登录考试系统");
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
        new JLabel("登录系统",JLabel.CENTER));
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
    p.add(BorderLayout.WEST, new JLabel("编号:"));
    JTextField idField = new JTextField();
    this.idField = idField;//****
    p.add(BorderLayout.CENTER, idField);
    return p;
  }
  private JPanel createPwdPane(){
    JPanel p = new JPanel(new BorderLayout());
    p.add(BorderLayout.WEST, new JLabel("密码:"));
    JPasswordField pwdField = new JPasswordField();
    this.pwdField = pwdField;//****
    pwdField.enableInputMethods(true);//Linux bug
    p.add(BorderLayout.CENTER, pwdField);
    return p;
  }

  private JPanel createBottomPane(){
    JPanel p = new JPanel(new FlowLayout());
    JButton login = new JButton("登录");
    JButton cancel = new JButton("取消");
    p.add(login);
    p.add(cancel);
    
    getRootPane().setDefaultButton(login);
    
    login.addActionListener(new ActionListener(){
      //当按钮对象被点击时候, 会执行方法actionPerformed()
      //ActionListener监听login按钮何时被点击
      //ActionEvent e 是按钮点击的时候, 场景信息(点击位置)
      //点击了那个对象(那个按钮)等
      public void actionPerformed(ActionEvent e) {
        //System.out.println("点击了Login"+e.getWhen());
        //访问控制器提供的登录方法, 完成登录流程
        //clientContext.login()依赖ClientContext实例
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
  /** ClientContext:客户端上下文,作为客户端界面控制器 */
  ClientContext clientContext;
  public void setClientContext(
      ClientContext clientContext){
    //clientContext的实例通过setClientContext()注入到
    //当前对象的属性this.clientContext中
    //依赖注入: IOC
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










