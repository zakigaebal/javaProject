import java.util.Scanner;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [1]추가 [2]수정 [3]검색 [4]탈퇴 [5]종료
		// 사용자가 사용하고자 하는 기능 입력받기
		// 5번이 입력되기 전까지 계속 메뉴를 반복할 수 있는 구조 갖기!

		System.out.print("[1]추가 [2]수정 [3]검색 [4]탈퇴 [5]종료");
		// 사용자가 사용하고자 하는 기능 입력받기
		// 5번이 입력되기 전까지 계속 메뉴를 반복할 수 있는 구조 갖기!
		Scanner sc = new Scanner(System.in);
		// 사용자의 결과를 확인하기 위한 전역변수
		int row =0;
		while (true) {
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("==회원 가입==");
				System.out.println("ID를 입력해주세요 >> ");
				String id = sc.next();
				System.out.println("pw를 입력해주세요 >> ");
				String pw = sc.next();
				System.out.println("이름을 입력해주세요 >> ");
				String name = sc.next();
				
				// insert 메소드를 호출!
				Controller controller = new Controller();
				row = controller.insert(id,pw,name);
				if (row > 0) {
					System.out.println("데이터 추가 성공!!!!");
				} else {
					System.out.println("추가 실패!!!!");
				}
			} 
			else if (menu == 2) {

			} else if (menu == 3) {

			} else if (menu == 4) {

			} else if (menu == 5) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			}

		}
	}

}
