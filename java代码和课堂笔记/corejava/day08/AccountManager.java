package day08;


/**
 * 帐号管理, 功能
 *   注册用户
 *   登录系统
 *   修改密码
 *   删除用户
 *   查询指定ID用户
 *   查询指定登录名用户
 *   查询全部用户
 */
public interface AccountManager {
  /** 注册用户 */
  User reg(String name, String pwd, String email);
  /** 登录 */
  User login(String name, String pwd);
  
  void updatePassword(int id, String password);
  
  User[] findAll();
  
  User findById(int id);
  
  User findByName(String name);
  
  User[] findByEmail(String email);
  
}










