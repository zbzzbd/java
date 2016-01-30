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
 * 实体数据的管理, 
 * 软件中的数据管理:
 *   从磁盘(文件)加载用户和考题数据到内存集合中
 * */
public class EntityContext {
  private Config config;
  
  public EntityContext(Config config) {
    this.config = config;
    loadUsers(config.getString("UserFile"));  
    loadQuestions(config.getString("QuestionFile"));
  }
  
  /** 
   * users 是用来存储所有用户信息的, 
   * 其中key是用户的ID, value是用户实例
   * 用户信息从磁盘文件加载
   */
  private HashMap<Integer, User> users =
    new HashMap<Integer, User>();
  
  /**
   * 加载并解析用户文件内容到users集合中
   * @param file 用户文件名
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
        //row=1001:刘苍松:1234:13810381038:liucs@tarena.com.cn
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
    //row=1001:刘苍松:1234:13810381038:liucs@tarena.com.cn
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
  
  /** 全部试题的集合, key是级别(level), 
   * value是 对于level下的所有试题 */
  private Map<Integer, List<Question>> questions = 
    new HashMap<Integer, List<Question>>();

  public List<Question> findQuestions(int level){
    return new ArrayList<Question>(questions.get(level));
  }
  
  /** 解析试题文件, 到questions集合中 */
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
        //解析流信息到 Question 对象 
        Question q = parseQuestion(str, in);
        addQuestion(q); //添加到集合
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
指出下面语句没有编译错误的是:
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
    // 以上字符串 切为: 如下结果
    // data:{"","2/3","5","5"}
    Question q = new Question();
    q.setAnswers(parseAnswer(data[1]));
    q.setScore(Integer.parseInt(data[2]));   
    q.setLevel(Integer.parseInt(data[3]));
    q.setTitle(in.readLine());//读取题干
    List<String> options = new ArrayList<String>();
    options.add(in.readLine());//连续读取4个选项
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






