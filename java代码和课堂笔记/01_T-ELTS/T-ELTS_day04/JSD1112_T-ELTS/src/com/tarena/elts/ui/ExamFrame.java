package com.tarena.elts.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.tarena.elts.entity.ExamInfo;
import com.tarena.elts.entity.QuestionInfo;
 

public class ExamFrame extends JFrame{
 
  private static final long serialVersionUID = 
    -5355432125621015300L;
  
  //ѡ���, ����𰸶�ȡ�Ĵ���
  private Option[] options = new Option[4];
  public ExamFrame() {
    init();
  }
  private void init(){
    setTitle("���ڿƼ����߲���");
    setSize(600,380);
    setContentPane(createContentPane());
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    addWindowListener(new WindowAdapter(){
      @Override
      public void windowClosing(WindowEvent e) {
        clientContext.send();
      }
    });
  }
  private JPanel createContentPane(){
    JPanel pane = new JPanel(new BorderLayout());
    pane.setBorder(new EmptyBorder(6,6,6,6));
    ImageIcon icon = new ImageIcon(
        getClass().getResource("exam_title.png"));            
    
    pane.add(BorderLayout.NORTH, 
        new JLabel(icon));
    
    pane.add(BorderLayout.CENTER,
        createCenterPane());
    
    pane.add(BorderLayout.SOUTH, 
        createToolsPane());
       
    return pane;
  }
  private JPanel createCenterPane() {
    JPanel pane = new JPanel(new BorderLayout());
//  ע��!
    examInfo = 
      new JLabel("����:XXX ����:XXX ����ʱ��:XXX", 
          JLabel.CENTER);
 
    pane.add(BorderLayout.NORTH, examInfo);
    
    pane.add(BorderLayout.CENTER, 
        createQuestionPane());
    pane.add(BorderLayout.SOUTH, 
        createOptionsPane());
    return pane;
  }
  private JPanel createOptionsPane(){
    JPanel pane = new JPanel();
    Option a = new Option(0,"A");
    Option b = new Option(1,"B");
    Option c = new Option(2,"C");
    Option d = new Option(3,"D");
    options[0]=a;
    options[1]=b;
    options[2]=c;
    options[3]=d;
    pane.add(a);
    pane.add(b);
    pane.add(c);
    pane.add(d);
    return pane;
  }
  private JScrollPane createQuestionPane() {
    JScrollPane pane = new JScrollPane();
    pane.setBorder(new TitledBorder("��Ŀ"));//�����
    
    //ע��!
    questionArea = new JTextArea();
    
    questionArea.setText("����\nA.\nB.");
    questionArea.setLineWrap(true);//����������ʾ
    questionArea.setEditable(false);//���ܹ��༭����
    //JTextArea ����ŵ� JScrollPane ����ͼ������(Viewport)
    pane.getViewport().add(questionArea);
    return pane;
  }
  private JPanel createToolsPane() {
    JPanel pane = new JPanel(new BorderLayout());
    pane.setBorder(new EmptyBorder(0,10,0,10));
//  ע��!
    questionCount =
      new JLabel("��Ŀ:20 �� 1��");
    
    timer =
      new JLabel("ʣ��ʱ��:222��");
 
    pane.add(BorderLayout.WEST, questionCount );
    pane.add(BorderLayout.EAST, timer );
    pane.add(BorderLayout.CENTER, createBtnPane());
    return pane;
  }
  private JPanel createBtnPane() {
    JPanel pane = new JPanel(new FlowLayout());
    prev = new JButton("��һ��");
    next = new JButton("��һ��");
    JButton send = new JButton("����");
 
    pane.add(prev);
    pane.add(next);
    pane.add(send);
    
    prev.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        clientContext.prev();
      }
    });
    next.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        clientContext.next();
      }
    });
    send.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e) {
        clientContext.send();
      }
    });
    
    return pane;
  }
  /** ʹ���ڲ�����չ�� JCheckBox ������val ����, �����ֵ*/
  class Option extends JCheckBox{
    private static final long serialVersionUID = 5569918347028393191L;
    int value;
    public Option(int val, String txt) {
      super(txt);
      this.value = val;
    }
  }
  
  private ClientContext clientContext;
  public void setClientContext(ClientContext clientContext) {
    this.clientContext = clientContext;
  }
  private JLabel examInfo;
  private JTextArea questionArea;
  public void updateView(
      ExamInfo examInfo, 
      QuestionInfo questionInfo) {
    this.examInfo.setText(examInfo.toString());
    questionArea.setText(questionInfo.toString());

    updateButtons(examInfo.getQuestionCount(), 
        questionInfo.getQuestionIndex());
    updateQuestionCount(examInfo.getQuestionCount(), 
        questionInfo.getQuestionIndex());
    updateOptions(questionInfo.getUserAnswers());
  }

  private JButton prev;
  private JButton next;
  private JLabel questionCount;

  private void updateOptions(List<Integer> userAnswers) {
    for (Option option : options) {
      option.setSelected(
          userAnswers.contains(option.value));
    }
  }
  private void updateQuestionCount(
      int questionCount, int questionIndex) {
    String str = "��Ŀ:"+ questionCount +" �� " +(questionIndex+1)+ " ��";
    this.questionCount.setText(str);
  }
  private void updateButtons(
      int questionCount, int questionIndex) {
    prev.setEnabled(questionIndex!=0);
    next.setEnabled((questionCount-1)!=questionIndex);
  }
  public List<Integer> getUserAnswers() {
    List<Integer> list = new ArrayList<Integer>();
    for(Option option:options){
      if(option.isSelected()){
        list.add(option.value);
      }
    }
    return list;
  }
  private JLabel timer;
  public void updateTime(long h, long m, long s) {
    String time = h +":"+m+":"+s;
    if(h==0 && m<5){
      timer.setForeground(new Color(0xC85848));
    }else{
      timer.setForeground(Color.blue);
    }
    timer.setText(time);
  }
}












