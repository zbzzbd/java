package day08.ext;

import java.util.Scanner;

public class TestSelfDefException {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UserManager userManager = new UserManager();
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("1 ע�᣻2 ��¼��3 �뿪");
			String cmd = sc.nextLine();
			if ("1".equals(cmd)){
				User u = regUser(userManager, sc);
				if (u != null){
					System.out.println("��ӭ[" + u + "]���룡");
				}
			}else if("2".equals(cmd)){
				User u = loginUser(userManager, sc);
				if(u != null){
					System.out.println("��ӭ[" + u + "]������");
				}
			}else if("3".equals(cmd)){
				break;
			}
		}
	}

	private static User loginUser(UserManager userManager, Scanner sc) {
		System.out.println("�������¼��Ϣ��(�û��� ����)");
		String info = sc.nextLine();
		String data[] = info.split("\\s+");
		User u = null;
		try{
			u = userManager.userLogin(data[0], data[1]);	
		}catch(NameOrPasswordException e){
			System.out.println(e.getMessage());
		}
		return u;
	}

	private static User regUser(UserManager userManager, Scanner sc) {
		System.out.println("������ע����Ϣ��(�û��� ���� email)");
		String info = sc.nextLine();
		String data[] = info.split("\\s+");
		User u = null;
		try{
		u = 
			userManager.userRegist(data[0], data[1], data[2]);
		}catch(UserExistException e){
			System.out.println(e.getMessage());
		}catch(EmailUsedException e){
			System.out.println(e.getMessage());
		}
		return u;
		
	}

}
