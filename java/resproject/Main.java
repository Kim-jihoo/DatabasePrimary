package resproject;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("�ݰ����ϴ�. ��ȭ���� �ٹ� ���� ��ȸ �����Դϴ�.\n");
		login();
		System.out.print("�����մϴ�. ��ȭ���� �ٹ� ���� ��ȸ �����Դϴ�.");
		return;
		
	}

	public static void login() {
		
		Scanner scanner = new Scanner(System.in);
		int code = -1;
		boolean loop = true;
		
		while(loop) {
			
			System.out.println("\n���� �̿��� ���� �α��� ���ּ���.");	
			System.out.printf("%-10s  %-10s  %-10s \n", "1. �α���", "2. ȸ������", "3. ����");
			System.out.print("��ȣ ���� : ");
			code = scanner.nextInt();
			scanner.nextLine();
			
			if(code == 1) {
				
				System.out.print("\n�α����� ���̵� �Է����ּ���. : ");
				String id = scanner.nextLine();
				
				System.out.print("��й�ȣ�� �Է����ּ���. : ");
				String pw = scanner.nextLine();
				
				// users db���� id, password �˻�
				Account account = new Account();
				int result = account.Login(id, pw);
				
				if(result == 1) {
					System.out.println("\n�α����� �Ϸ�Ǿ����ϴ�.\n");
					
					menu(id, pw);
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
				
				System.out.print("\n������ ���̵� �Է����ּ���. : ");
				String id = scanner.nextLine();
				
				System.out.print("��й�ȣ�� �Է����ּ���. : ");
				String pw = scanner.nextLine();
				
				// users db�� id, password �Է�
				Account account = new Account();
				int result = account.Create(id, pw);
				
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
				System.out.printf("%-10s  %-10s  %-10s  %-15s  %-15s  %-15s  %-10s \n", "1. ���� ���", "2. ���� ����", "3. ���� ����", "4. �Է� ���� �̻� �Ĵ� ��õ", "5. �Է� ���� ���� �Ĵ� ��õ", "6. �Է� ���� �Ĵ� ��õ", "7. �α׾ƿ�");
				System.out.print("��ȣ ���� : ");
				code = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\n������ �߻��߽��ϴ�.");
				if (code == 1) {
					System.out.println("1���� 5 ���� �Ǽ��� �Է����ּ���.\n");
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
					scanner.nextLine();
					System.out.print("�Է��� ������ �Ĵ� �̸��� �Է����ּ���. : ");
					String restaurant = scanner.nextLine();

					// �޴� ����Ʈ �����ֱ�
					view.Menu(restaurant);
					System.out.println("�Է��� ������ �޴� �̸��� �Է����ּ���. : ");
					String menu = scanner.nextLine();
								
					System.out.print("������ �Է����ּ���. (1~5 ���� �Ǽ�) : ");
					double rate = scanner.nextDouble();
					scanner.nextLine();
					
					System.out.print("�Է��� ������ �ڸ�Ʈ�� �Է����ּ���. : ");
					String comment = scanner.nextLine();
								
					// review�� res_name, menu_name, rate, comment �Է�
					Review review = new Review();
					int result = review.Create(id, restaurant, menu, comment, rate);
					
					if (result == 1) {
						System.out.println("\n���䰡 �ԷµǾ����ϴ�.\n");
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
					scanner.nextLine();
					System.out.print("������ ������ ���̵� �Է����ּ���. : ");
					int rev_id = scanner.nextInt();
					
					// review�� id, res_name, menu_name�� ���� ����
					Review review = new Review();
					int result = review.Drop(rev_id);
					
					if (result == 1) {
						System.out.println("\n���䰡 �����Ǿ����ϴ�.\n");
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
					scanner.nextLine();
					System.out.print("������ ������ ���̵� �Է����ּ���. : ");
					int rev_id = scanner.nextInt();
					
					System.out.print("������ �Է����ּ���. (1~5 �Ǽ�) : ");
					double rate = scanner.nextDouble();
					scanner.nextLine();
					
					System.out.print("�Է��� ������ �ڸ�Ʈ�� �Է����ּ���. : ");
					String comment = scanner.nextLine();
					
					// review�� rate, comment �Է�
					Review review = new Review();
					int result = review.Update(id, rev_id, rate, comment);
					
					if (result == 1) {
						System.out.println("\n���䰡 �����Ǿ����ϴ�.\n");
					} else {
						System.out.println("\n������ �߻��Ͽ� ���� ������ �����߽��ϴ�.\n");
					}
	
				} catch (InputMismatchException e) {
					System.out.println("\n������ �߻��߽��ϴ�.\n");
				}
				
			} else if (code == 4) {
				
				try {
					
					System.out.println("\n�Է��� ���� �̻��� �Ĵ��� ��õ�մϴ�.\n");
					
					System.out.print("������ �Է����ּ���. (1~5 �Ǽ�) : ");
					double rate = scanner.nextDouble();
					
					Recommendation recommendation = new Recommendation();
					int result = recommendation.ByRate(rate);
					
					if (result == 1) {
						System.out.println("\n�Ĵ��� ��õ�Ǿ����ϴ�.\n");
					} else {
						System.out.println("\n������ �߻��Ͽ� �Ĵ� ��õ�� �����߽��ϴ�.\n");
					}
	
				} catch (InputMismatchException e) {
					System.out.println("\n������ �߻��߽��ϴ�.\n");
				}
				
				
				
			} else if (code == 5) {
				
				try {
					System.out.println("\n�Է��� ���� ������ �Ĵ��� ��õ�մϴ�.\n");
					
					System.out.print("������ �Է����ּ���. : ");
					int price = scanner.nextInt();
					
					Recommendation recommendation = new Recommendation();
					int result = recommendation.ByPrice(price);
					
					if (result == 1) {
						System.out.println("\n�Ĵ��� ��õ�Ǿ����ϴ�.\n");
					} else {
						System.out.println("\n������ �߻��Ͽ� �Ĵ� ��õ�� �����߽��ϴ�.\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("\n������ �߻��߽��ϴ�.\n");
				}
				
			} else if (code == 6) {
				
				try {
					System.out.println("\n�Է��� ������ �Ĵ��� ��õ�մϴ�.\n");
					View view = new View();
					view.Area();
					scanner.nextLine();
					System.out.print("������ �Է����ּ���. : ");
					String area = scanner.nextLine();
					
					Recommendation recommendation = new Recommendation();
					int result = recommendation.ByArea(area);
					
					if (result == 1) {
						System.out.println("\n�Ĵ��� ��õ�Ǿ����ϴ�.\n");
					} else {
						System.out.println("\n������ �߻��Ͽ� �Ĵ� ��õ�� �����߽��ϴ�.\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("\n������ �߻��߽��ϴ�.\n");
				}
				
			} else if (code == 7) {
				System.out.println("\n�α׾ƿ� �Ǿ����ϴ�.\n");
				loop = false;
				
			} else {
				System.out.println("\n��ȣ�� Ȯ���Ͻð� �ٽ� �Է����ּ���.\n");
			}
		}
		
		System.out.println("");
	}
	
}
