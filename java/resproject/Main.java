package resproject;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("�ݰ����ϴ�. ��ȭ���� �ٹ� ���� ��ȸ �����Դϴ�.\n");
		login();
		System.out.println("�����մϴ�. ��ȭ���� �ٹ� ���� ��ȸ �����Դϴ�.");
		return;
		
	}

	public static void login() {
		
		Scanner scanner = new Scanner(System.in);
		int code = -1;
		boolean loop = true;
		
		while(loop) {
			
			System.out.println("���� �̿��� ���� �α��� ���ּ���.");	
			System.out.println("1. �α��� \t 2. ȸ������ \t 3. ����");
			System.out.print("��ȣ ���� : ");
			code = scanner.nextInt();
			
			if(code == 1) {
				
				System.out.print("�α����� ���̵� �Է����ּ���. : ");
				String id = scanner.next();
				
				System.out.print("��й�ȣ�� �Է����ּ���. : ");
				String password = scanner.next();
				
				// users db���� id, password �˻�
				Account account = new Account(id, password);
				int result = account.Login(id, password);
				
				if(result == 1) {
					System.out.println("\n�α����� �Ϸ�Ǿ����ϴ�.\n");
					
					menu(id, password);
				}
				
				else if(result == 0) {
					System.out.println("\n��й�ȣ�� ��ġ���� �ʽ��ϴ�.\n");
				}
				
				else if(result == -1) {
					System.out.println("\n���̵� �������� �ʽ��ϴ�.\n");
				}
				
				else if(result == -2) {
					System.out.println("\n������ �߻��Ͽ� �α��ο� �����߽��ϴ�.\n");
				}
				
			} else if (code == 2) {
				
				System.out.print("������ ���̵� �Է����ּ���. : ");
				String id = scanner.next();
				
				System.out.print("��й�ȣ�� �Է����ּ���. : ");
				String password = scanner.next();
				
				// users db�� id, password �Է�
				Account account = new Account(id, password);
				int result = account.Create(id, password);
				
				if (result == 1) {
					System.out.println("\n������ �����Ǿ����ϴ�.\n");
				} else if (result == -1) {
					System.out.println("\n�̹� ���̵� �����մϴ�.\n");
				} else {
					System.out.println("\n������ �߻��Ͽ� ���� ������ �����߽��ϴ�.\n");
				}				
				
			} else if (code == 3) {
				
				System.out.println("\n���񽺸� �����մϴ�.\n");
				loop = false;
				
			} else {
				
				System.out.println("\n������ �߻��߽��ϴ�.");
				System.out.println("��ȣ�� Ȯ���Ͻð� �ٽ� �Է����ּ���.\n");
				
			}
		}
	}
	
	public static void menu(String id, String pw) {
		
		Scanner scanner = new Scanner(System.in);
		int code = -1;
		boolean loop = true;
		
		while(loop) {
			
			try {
				System.out.println("�޴��� �������ּ���.");			
				System.out.println("1. ���� ��� \t 2. ���� ���� \t 3. ���� ���� \t 4. �Ĵ� ���� �� ��ȸ \t 5. ���� �̻� �Ĵ� ��õ \t 6. ���ݴ� �޴� ��õ \t 7. �α׾ƿ�");
				System.out.print("��ȣ ���� : ");
				code = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\n������ �߻��߽��ϴ�.");
				if (code == 1) {
					System.out.print("1���� 5 ���� ������ �Է����ּ���.\n");
				} else {
					System.out.println("��ȣ�� Ȯ���Ͻð� �ٽ� �Է����ּ���.\n");
				}
				
				break;
			}
			
			
			
			if (code == 1) {
				
				try {
					
					// �Ĵ� ����Ʈ �����ֱ�
					View view = new View();
					view.Restaurant();
					System.out.print("�Է��� ������ �Ĵ� �̸��� �Է����ּ���. : ");
					String restaurant = scanner.next();

					// �޴� ����Ʈ �����ֱ�
					view.Menu(restaurant);
					System.out.print("�Է��� ������ �޴� �̸��� �Է����ּ���. : ");
					String menu = scanner.next();
								
					System.out.print("���� ������ �Է����ּ���. (1~5 ����) : ");
					int rate = scanner.nextInt();
								
					System.out.print("�Է��� ������ �ڸ�Ʈ�� �Է����ּ���. : ");
					String comment = scanner.next();
								
					// review�� res_name, menu_name, rate, comment �Է�
					Review review = new Review();
					int result = review.Create(id, restaurant, menu, rate, comment);
					
					if (result == 1) {
						System.out.println("\n���䰡 �ԷµǾ����ϴ�.\n");
					} else if (result == -1) {
						System.out.println("\n�̹� ���䰡 �����մϴ�.\n");
					} else {
						System.out.println("\n������ �߻��Ͽ� ���� �Է¿� �����߽��ϴ�.\n");
					}
					
				} catch (InputMismatchException e) {
					System.out.println("\n������ �߻��߽��ϴ�.\n");
				}

				
			} else if (code == 2) {
				
				try {
					
					// �ش� id�� ���� ����Ʈ �����ֱ�
					View view = new View();
					view.Review(id);
					System.out.print("������ ������ �Ĵ� �̸��� �Է����ּ���. : ");
					String restaurant = scanner.next();
					
					System.out.print("������ ������ �޴� �̸��� �Է����ּ���. : ");
					String menu = scanner.next();
					
					// review�� id, res_name, menu_name�� ���� ����
					Review review = new Review();
					int result = review.Drop(id, restaurant, menu);
					
					if (result == 1) {
						System.out.println("\n���䰡 �����Ǿ����ϴ�.\n");
					} else if (result == -1) {
						System.out.println("\n���䰡 �������� �ʽ��ϴ�.\n");
					} else {
						System.out.println("\n������ �߻��Ͽ� ���� ������ �����߽��ϴ�.\n");
					}
					
				} catch (InputMismatchException e) {
					System.out.println("\n������ �߻��߽��ϴ�.\n");
				}
				
			} else if (code == 3) {
				
				try {
					
					// �ش� id�� ���� ����Ʈ �����ֱ�
					View view = new View();
					view.Review(id);
					System.out.print("������ ������ �Ĵ� �̸��� �Է����ּ���. : ");
					String restaurant = scanner.next();
					
					System.out.print("������ ������ �޴� �̸��� �Է����ּ���. : ");
					String menu = scanner.next();
					
					System.out.print("���� ������ �Է����ּ���. (1~5 ����) : ");
					int rate = scanner.nextInt();
					
					System.out.print("�Է��� ������ �ڸ�Ʈ�� �Է����ּ���. : ");
					String comment = scanner.next();
					
					// review�� rate, comment �Է�
					Review review = new Review();
					int result = review.Update(id, restaurant, menu, rate, comment);
					
					if (result == 1) {
						System.out.println("\n���䰡 �����Ǿ����ϴ�.\n");
					} else if (result == -1) {
						System.out.println("\n���䰡 �������� �ʽ��ϴ�.\n");
					} else {
						System.out.println("\n������ �߻��Ͽ� ���� ������ �����߽��ϴ�.\n");
					}
	
				} catch (InputMismatchException e) {
					System.out.println("\n������ �߻��߽��ϴ�.\n");
				}
				
			} else if (code == 4) {
				
				
			} else if (code == 5) {

				
			} else if (code == 6) {

				
			} else if (code == 7) {
				System.out.print("\n�α׾ƿ� �Ǿ����ϴ�.\n");
				loop = false;
				
			} else {
				System.out.println("\n��ȣ�� Ȯ���Ͻð� �ٽ� �Է����ּ���.\n");
			}
		}
		
		System.out.println("");
	}
	
}
