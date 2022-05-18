import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
public class Ex03_Delete {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement psmt = null;
		System.out.println("삭제할 id를 입력해주세요 >> ");
		String id = sc.next();
		// delete문장시작
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "delete from mem where mem_id = ?";

			// DB로 전송하기 위한 sql문 담기!
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int row = psmt.executeUpdate();

			System.out.println(row);
			if (row > 0) {
				System.out.println("데이터 delete 성공!!!!!");
			} else {
				System.out.println("데이터 delete 실패!!!!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("연결실패");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("반납오류");
				e.printStackTrace();
			}
		}
	}
}
