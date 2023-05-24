package resproject;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("반갑습니다. 이화여대 근방 맛집 조회 서비스입니다.\n");
		login();
		System.out.println("감사합니다. 이화여대 근방 맛집 조회 서비스입니다.");
		return;
		
	}

	public static void login() {
		
		Scanner scanner = new Scanner(System.in);
		int code = -1;
		boolean loop = true;
		
		while(loop) {
			
			System.out.println("서비스 이용을 위해 로그인 해주세요.");	
			System.out.println("1. 로그인 \t 2. 회원가입 \t 3. 종료");
			System.out.print("번호 선택 : ");
			code = scanner.nextInt();
			
			if(code == 1) {
				
				System.out.print("로그인할 아이디를 입력해주세요. : ");
				String id = scanner.next();
				
				System.out.print("비밀번호를 입력해주세요. : ");
				String password = scanner.next();
				
				// users db에서 id, password 검사
				Account account = new Account(id, password);
				int result = account.Login(id, password);
				
				if(result == 1) {
					System.out.println("\n로그인이 완료되었습니다.\n");
					
					menu(id, password);
				}
				
				else if(result == 0) {
					System.out.println("\n비밀번호가 일치하지 않습니다.\n");
				}
				
				else if(result == -1) {
					System.out.println("\n아이디가 존재하지 않습니다.\n");
				}
				
				else if(result == -2) {
					System.out.println("\n오류가 발생하여 로그인에 실패했습니다.\n");
				}
				
			} else if (code == 2) {
				
				System.out.print("가입할 아이디를 입력해주세요. : ");
				String id = scanner.next();
				
				System.out.print("비밀번호를 입력해주세요. : ");
				String password = scanner.next();
				
				// users db에 id, password 입력
				Account account = new Account(id, password);
				int result = account.Create(id, password);
				
				if (result == 1) {
					System.out.println("\n계정이 생성되었습니다.\n");
				} else if (result == -1) {
					System.out.println("\n이미 아이디가 존재합니다.\n");
				} else {
					System.out.println("\n오류가 발생하여 계정 생성에 실패했습니다.\n");
				}				
				
			} else if (code == 3) {
				
				System.out.println("\n서비스를 종료합니다.\n");
				loop = false;
				
			} else {
				
				System.out.println("\n오류가 발생했습니다.");
				System.out.println("번호를 확인하시고 다시 입력해주세요.\n");
				
			}
		}
	}
	
	public static void menu(String id, String pw) {
		
		Scanner scanner = new Scanner(System.in);
		int code = -1;
		boolean loop = true;
		
		while(loop) {
			
			try {
				System.out.println("메뉴를 선택해주세요.");			
				System.out.println("1. 리뷰 등록 \t 2. 리뷰 삭제 \t 3. 리뷰 수정 \t 4. 식당 평점 순 조회 \t 5. 평점 이상 식당 추천 \t 6. 가격대 메뉴 추천 \t 7. 로그아웃");
				System.out.print("번호 선택 : ");
				code = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\n오류가 발생했습니다.");
				if (code == 1) {
					System.out.print("1부터 5 사이 정수를 입력해주세요.\n");
				} else {
					System.out.println("번호를 확인하시고 다시 입력해주세요.\n");
				}
				
				break;
			}
			
			
			
			if (code == 1) {
				
				try {
					
					// 식당 리스트 보여주기
					View view = new View();
					view.Restaurant();
					System.out.print("입력할 리뷰의 식당 이름을 입력해주세요. : ");
					String restaurant = scanner.next();

					// 메뉴 리스트 보여주기
					view.Menu(restaurant);
					System.out.print("입력할 리뷰의 메뉴 이름을 입력해주세요. : ");
					String menu = scanner.next();
								
					System.out.print("리뷰 점수를 입력해주세요. (1~5 정수) : ");
					int rate = scanner.nextInt();
								
					System.out.print("입력할 리뷰의 코멘트를 입력해주세요. : ");
					String comment = scanner.next();
								
					// review에 res_name, menu_name, rate, comment 입력
					Review review = new Review();
					int result = review.Create(id, restaurant, menu, rate, comment);
					
					if (result == 1) {
						System.out.println("\n리뷰가 입력되었습니다.\n");
					} else if (result == -1) {
						System.out.println("\n이미 리뷰가 존재합니다.\n");
					} else {
						System.out.println("\n오류가 발생하여 리뷰 입력에 실패했습니다.\n");
					}
					
				} catch (InputMismatchException e) {
					System.out.println("\n오류가 발생했습니다.\n");
				}

				
			} else if (code == 2) {
				
				try {
					
					// 해당 id의 리뷰 리스트 보여주기
					View view = new View();
					view.Review(id);
					System.out.print("삭제할 리뷰의 식당 이름을 입력해주세요. : ");
					String restaurant = scanner.next();
					
					System.out.print("삭제할 리뷰의 메뉴 이름을 입력해주세요. : ");
					String menu = scanner.next();
					
					// review의 id, res_name, menu_name을 통해 삭제
					Review review = new Review();
					int result = review.Drop(id, restaurant, menu);
					
					if (result == 1) {
						System.out.println("\n리뷰가 삭제되었습니다.\n");
					} else if (result == -1) {
						System.out.println("\n리뷰가 존재하지 않습니다.\n");
					} else {
						System.out.println("\n오류가 발생하여 리뷰 삭제에 실패했습니다.\n");
					}
					
				} catch (InputMismatchException e) {
					System.out.println("\n오류가 발생했습니다.\n");
				}
				
			} else if (code == 3) {
				
				try {
					
					// 해당 id의 리뷰 리스트 보여주기
					View view = new View();
					view.Review(id);
					System.out.print("수정할 리뷰의 식당 이름을 입력해주세요. : ");
					String restaurant = scanner.next();
					
					System.out.print("수정할 리뷰의 메뉴 이름을 입력해주세요. : ");
					String menu = scanner.next();
					
					System.out.print("리뷰 점수를 입력해주세요. (1~5 정수) : ");
					int rate = scanner.nextInt();
					
					System.out.print("입력할 리뷰의 코멘트를 입력해주세요. : ");
					String comment = scanner.next();
					
					// review에 rate, comment 입력
					Review review = new Review();
					int result = review.Update(id, restaurant, menu, rate, comment);
					
					if (result == 1) {
						System.out.println("\n리뷰가 수정되었습니다.\n");
					} else if (result == -1) {
						System.out.println("\n리뷰가 존재하지 않습니다.\n");
					} else {
						System.out.println("\n오류가 발생하여 리뷰 수정에 실패했습니다.\n");
					}
	
				} catch (InputMismatchException e) {
					System.out.println("\n오류가 발생했습니다.\n");
				}
				
			} else if (code == 4) {
				
				
			} else if (code == 5) {

				
			} else if (code == 6) {

				
			} else if (code == 7) {
				System.out.print("\n로그아웃 되었습니다.\n");
				loop = false;
				
			} else {
				System.out.println("\n번호를 확인하시고 다시 입력해주세요.\n");
			}
		}
		
		System.out.println("");
	}
	
}
