package day08;
/** 系统用户 */
public class User {
  private int id;
  private String name;
  private String pwd;
  private String email;

  public User() {
  }
  public User(int id, String name, String pwd) {
    this.id = id;
    this.name = name;
    this.pwd = pwd;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public String toString() {
    return name;
  }
  @Override
  public boolean equals(Object obj) {
    if(obj==null)
      return false;
    if(obj==this)
      return true;
    if (obj instanceof User) {
      User o = (User) obj;
      return id==o.id;
    }
    return false;
  }
  @Override
  public int hashCode() {
    return id;
  }
  
  
}
