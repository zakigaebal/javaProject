import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
	// main에서 호출하는 기능들을 관리할수 있는 클래스

	// 모든 메소드에서 객체를 사용할 수 있도록 전역변수 지정!
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	// 기능 수행결과를 담을 수 있는 변수 생성
	int row = 0;
	
	// JDBC 접속을 위한 메소드 생성! => getCon()
	public void getCon() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr"; // 데이터베이스 계정
			String password = "hr"; // 비밀번호
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//객체를 닫아줄수 있는 close() 생성
	public void close() {
		try {
			if(rs != null) rs.close();
			
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("반납 오류");
			e.printStackTrace();
		}
	}

	// jdbc 저장하기 위한 메소드
	// insert
	public int insert(String id, String pw, String name) {
		getCon();
		try {
			String sql = "insert into mem values(?, ?, ?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			row = psmt.executeUpdate();

			
			
		} 
		catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} 
		finally {
			close();
		}
		return row;
	}
	// update
	// delete
	// select
}
