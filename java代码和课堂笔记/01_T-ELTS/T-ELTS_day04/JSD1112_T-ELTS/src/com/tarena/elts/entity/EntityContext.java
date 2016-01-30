package com.tarena.elts.entity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tarena.elts.util.Config;

/** 
 * ʵ�����ݵĹ���, 
 * ����е����ݹ���:
 *   �Ӵ���(�ļ�)�����û��Ϳ������ݵ��ڴ漯����
 * */
public class EntityContext {
  private Config config;
  
  public EntityContext(Config config) {
    this.config = config;
    loadUsers(config.getString("UserFile"));  
    loadQuestions(config.getString("QuestionFile"));
  }
  
  /** 
   * users �������洢�����û���Ϣ��, 
   * ����key���û���ID, value���û�ʵ��
   * �û���Ϣ�Ӵ����ļ�����
   */
  private HashMap<Integer, User> users =
    new HashMap<Integer, User>();
  
  /**
   * ���ز������û��ļ����ݵ�users������
   * @param file �û��ļ���
   */
  private void loadUsers(String file){
    try{
      BufferedReader in= 
        new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(
                    new FileInputStream(file)),"GBK"));
      String row;
      while((row=in.readLine())!=null){
        row = row.trim();
        if(row.equals("") || row.startsWith("#")){
          continue;
        }
        //row=1001:������:1234:13810381038:liucs@tarena.com.cn
        User user = parseUser(row);
        users.put(user.getId(), user);
      }
      in.close();
    }catch(IOException e){
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  
  private User parseUser(String row) {
    //row=1001:������:1234:13810381038:liucs@tarena.com.cn
    String[] data = row.split(":");
    User user = new User();
    user.setId(Integer.parseInt(data[0]));
    user.setName(data[1]);
    user.setPasswd(data[2]);
    user.setPhone(data[3]);
    user.setEmail(data[4]);
    return user;
  }

  public User findUserById(int id) {
    return users.get(id); 
  }
  
  /** ȫ������ļ���, key�Ǽ���(level), 
   * value�� ����level�µ��������� */
  private Map<Integer, List<Question>> questions = 
    new HashMap<Integer, List<Question>>();

  public List<Question> findQuestions(int level){
    return new ArrayList<Question>(questions.get(level));
  }
  
  /** ���������ļ�, ��questions������ */
  private void loadQuestions(String file){
    try {
      BufferedReader in = 
        new BufferedReader(
            new InputStreamReader(
                new BufferedInputStream(
                    new FileInputStream(file)), 
                    "gbk"));
      String str;
      while((str = in.readLine())!=null){
        str = str.trim();
        if(str.equals("") || str.startsWith("#")){
          continue;
        }
        //��������Ϣ�� Question ���� 
        Question q = parseQuestion(str, in);
        addQuestion(q); //��ӵ�����
      }
      in.close(); 
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  private void addQuestion(Question q) {
//    if(questions.containsKey(q.getLevel())){
//      questions.get(q.getLevel()).add(q);
//    }else{
//      List<Question> list = new ArrayList<Question>();
//      list.add(q);
//      questions.put(q.getLevel(), list);
//    }
    List<Question> list = 
      questions.get(q.getLevel());
    if(list==null){
      list = new ArrayList<Question>();
      questions.put(q.getLevel(), list);
    }
    list.add(q);
    //System.out.println("q:"+q);
    //System.out.println("list:"+list);
    //System.out.println("questions:"+questions);
  }
/*
@answer=2/3,score=5,level=5
ָ���������û�б���������:
long n = 999999999999;
int n = 999999999999L;
long n = 999999999999L; 
double n = 999999999999;
 */
  private Question parseQuestion(
      String str, BufferedReader in) 
    throws IOException{
    String[] data = str.split("[@,][a-z]+=");
    //str: @answer=2/3,score=5,level=5
    // �����ַ��� ��Ϊ: ���½��
    // data:{"","2/3","5","5"}
    Question q = new Question();
    q.setAnswers(parseAnswer(data[1]));
    q.setScore(Integer.parseInt(data[2]));   
    q.setLevel(Integer.parseInt(data[3]));
    q.setTitle(in.readLine());//��ȡ���
    List<String> options = new ArrayList<String>();
    options.add(in.readLine());//������ȡ4��ѡ��
    options.add(in.readLine());
    options.add(in.readLine());
    options.add(in.readLine());
    q.setOptions(options);
    q.setType(q.getAnswers().size()==1? 
          Question.SINGLE_SELECTION : 
          Question.MULTI_SELECTION);
    return q;
  }
  // answer: "2/3"
  private List<Integer> parseAnswer(
      String answer) {
    List<Integer> list = 
      new ArrayList<Integer>();
    String[] data = answer.split("/");
    for (String s : data) {
      list.add(Integer.parseInt(s));
    }
    return list;
  }


  public int getTimeLimit() {
    return config.getInt("TimeLimit"); 
  } 

  public String getTitle() {
    return config.getString("PaperTitle"); 
  }

  
  public static void main(String[] args) {
    Config config = new Config("client.properties");
    EntityContext context = new EntityContext(config);
    //context.loadUsers("user.txt");
    System.out.println(context.users); 
    System.out.println(context.questions); 
  }
}






