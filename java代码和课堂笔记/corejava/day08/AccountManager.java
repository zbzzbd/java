package day08;


/**
 * �ʺŹ���, ����
 *   ע���û�
 *   ��¼ϵͳ
 *   �޸�����
 *   ɾ���û�
 *   ��ѯָ��ID�û�
 *   ��ѯָ����¼���û�
 *   ��ѯȫ���û�
 */
public interface AccountManager {
  /** ע���û� */
  User reg(String name, String pwd, String email);
  /** ��¼ */
  User login(String name, String pwd);
  
  void updatePassword(int id, String password);
  
  User[] findAll();
  
  User findById(int id);
  
  User findByName(String name);
  
  User[] findByEmail(String email);
  
}










