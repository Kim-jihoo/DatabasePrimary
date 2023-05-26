package resproject;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("반갑습니다. 이화여대 근방 맛집 조회 서비스입니다.\n");
		login();
		System.out.print("감사합니다. 이화여대 근방 맛집 조회 서비스입니다.");
		return;
		
	}

	public static void login() {
		
		Scanner scanner = new Scanner(System.in);
		int code = -1;
		boolean loop = true;
		
		while(loop) {
			
			System.out.println("\n서비스 이용을 위해 로그인 해주세요.");	
			System.out.printf("%-10s  %-10s  %-10s \n", "1. 로그인", "2. 회원가입", "3. 종료");
			System.out.print("번호 선택 : ");
			code = scanner.nextInt();
			scanner.nextLine();
			
			if(code == 1) {
				
				System.out.print("\n로그인할 아이디를 입력해주세요. : ");
				String id = scanner.nextLine();
				
				System.out.print("비밀번호를 입력해주세요. : ");
				String pw = scanner.nextLine();
				
				// users db에서 id, password 검사
				Account account = new Account();
				int result = account.Login(id, pw);
				
				if(result == 1) {
					System.out.println("\n로그인이 완료되었습니다.\n");
					
					menu(id, pw);
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
				
				System.out.print("\n가입할 아이디를 입력해주세요. : ");
				String id = scanner.nextLine();
				
				System.out.print("비밀번호를 입력해주세요. : ");
				String pw = scanner.nextLine();
				
				// users db에 id, password 입력
				Account account = new Account();
				int result = account.Create(id, pw);
				
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
				System.out.printf("%-10s  %-10s  %-10s  %-15s  %-15s  %-15s  %-10s \n", "1. 리뷰 등록", "2. 리뷰 삭제", "3. 리뷰 수정", "4. 입력 평점 이상 식당 추천", "5. 입력 가격 이하 식당 추천", "6. 입력 구역 식당 추천", "7. 로그아웃");
				System.out.print("번호 선택 : ");
				code = scanner.nextInt();
			} catch(InputMismatchException e) {
				System.out.println("\n오류가 발생했습니다.");
				if (code == 1) {
					System.out.println("1부터 5 사이 실수를 입력해주세요.\n");
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
					scanner.nextLine();
					System.out.print("입력할 리뷰의 식당 이름을 입력해주세요. : ");
					String restaurant = scanner.nextLine();

					// 메뉴 리스트 보여주기
					view.Menu(restaurant);
					System.out.println("입력할 리뷰의 메뉴 이름을 입력해주세요. : ");
					String menu = scanner.nextLine();
								
					System.out.print("점수를 입력해주세요. (1~5 사이 실수) : ");
					double rate = scanner.nextDouble();
					scanner.nextLine();
					
					System.out.print("입력할 리뷰의 코멘트를 입력해주세요. : ");
					String comment = scanner.nextLine();
								
					// review에 res_name, menu_name, rate, comment 입력
					Review review = new Review();
					int result = review.Create(id, restaurant, menu, comment, rate);
					
					if (result == 1) {
						System.out.println("\n리뷰가 입력되었습니다.\n");
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
					scanner.nextLine();
					System.out.print("삭제할 리뷰의 아이디를 입력해주세요. : ");
					int rev_id = scanner.nextInt();
					
					// review의 id, res_name, menu_name을 통해 삭제
					Review review = new Review();
					int result = review.Drop(rev_id);
					
					if (result == 1) {
						System.out.println("\n리뷰가 삭제되었습니다.\n");
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
					scanner.nextLine();
					System.out.print("수정할 리뷰의 아이디를 입력해주세요. : ");
					int rev_id = scanner.nextInt();
					
					System.out.print("점수를 입력해주세요. (1~5 실수) : ");
					double rate = scanner.nextDouble();
					scanner.nextLine();
					
					System.out.print("입력할 리뷰의 코멘트를 입력해주세요. : ");
					String comment = scanner.nextLine();
					
					// review에 rate, comment 입력
					Review review = new Review();
					int result = review.Update(id, rev_id, rate, comment);
					
					if (result == 1) {
						System.out.println("\n리뷰가 수정되었습니다.\n");
					} else {
						System.out.println("\n오류가 발생하여 리뷰 수정에 실패했습니다.\n");
					}
	
				} catch (InputMismatchException e) {
					System.out.println("\n오류가 발생했습니다.\n");
				}
				
			} else if (code == 4) {
				
				try {
					
					System.out.println("\n입력한 평점 이상의 식당을 추천합니다.\n");
					
					System.out.print("평점을 입력해주세요. (1~5 실수) : ");
					double rate = scanner.nextDouble();
					
					Recommendation recommendation = new Recommendation();
					int result = recommendation.ByRate(rate);
					
					if (result == 1) {
						System.out.println("\n식당이 추천되었습니다.\n");
					} else {
						System.out.println("\n오류가 발생하여 식당 추천에 실패했습니다.\n");
					}
	
				} catch (InputMismatchException e) {
					System.out.println("\n오류가 발생했습니다.\n");
				}
				
				
				
			} else if (code == 5) {
				
				try {
					System.out.println("\n입력한 가격 이하의 식당을 추천합니다.\n");
					
					System.out.print("가격을 입력해주세요. : ");
					int price = scanner.nextInt();
					
					Recommendation recommendation = new Recommendation();
					int result = recommendation.ByPrice(price);
					
					if (result == 1) {
						System.out.println("\n식당이 추천되었습니다.\n");
					} else {
						System.out.println("\n오류가 발생하여 식당 추천에 실패했습니다.\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("\n오류가 발생했습니다.\n");
				}
				
			} else if (code == 6) {
				
				try {
					System.out.println("\n입력한 구역의 식당을 추천합니다.\n");
					View view = new View();
					view.Area();
					scanner.nextLine();
					System.out.print("구역을 입력해주세요. : ");
					String area = scanner.nextLine();
					
					Recommendation recommendation = new Recommendation();
					int result = recommendation.ByArea(area);
					
					if (result == 1) {
						System.out.println("\n식당이 추천되었습니다.\n");
					} else {
						System.out.println("\n오류가 발생하여 식당 추천에 실패했습니다.\n");
					}
				} catch (InputMismatchException e) {
					System.out.println("\n오류가 발생했습니다.\n");
				}
				
			} else if (code == 7) {
				System.out.println("\n로그아웃 되었습니다.\n");
				loop = false;
				
			} else {
				System.out.println("\n번호를 확인하시고 다시 입력해주세요.\n");
			}
		}
		
		System.out.println("");
	}
	
}
