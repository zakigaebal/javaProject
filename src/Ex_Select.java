import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex_Select {

	public static void main(String[] args) {
		// JDBC 연결에 필요한 객체 생성하기
		// Connection, PreparedStatement
		DatabaseInfo di = new DatabaseInfo();
		ArrayList<UserList> list = new ArrayList<UserList>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		// 사용자로 부터 내용을 확인하고 싶은 id값 입력 받기
		// -> sql 연결 => 입력받은 id에 대한 모든정보(id, pw, name) 출력하기

		try {
			System.out.print("아이디 입력 >> ");
			String inputId = sc.next();

			// 1. 동적로딩 => Class.forName()
			Class.forName(di.cname);
			// 2. DB 연결
			String url = di.url;
			String user = di.user;
			String password = di.pw;
			conn = DriverManager.getConnection(url, user, password);
			// 3. sql 전송
			String sql = "select * from mem";
			String sql2 = "select * from mem where mem_id=" + "'" + inputId + "'";
			// String sql = "select * from mem where mem_pw= '1111'";
			psmt = conn.prepareStatement(sql2);

			// sql문 실행(★★★★★)
			rs = psmt.executeQuery();

			if (rs != null) {
				// ResultSet에 담긴 결과를 ArrayList에 담기
				while (rs.next()) {
//				String id = rs.getString("mem_id");
//				String pw = rs.getString("mem_pw");
//				String name = rs.getString("mem_name");
//				System.out.println(id + "/" + pw +"/"+name);

					UserList users = new UserList();
					users.setId(rs.getString("mem_id"));
					users.setPw(rs.getString("mem_pw"));
					users.setName(rs.getString("mem_name"));
					list.add(users);
				}

				// 결과물 출력
				for (int i = 0; i < list.size(); i++) {
					System.out.println("회원아이디:" + list.get(i).getId());
					System.out.println("회원비번:" + list.get(i).getPw());
					System.out.println("회원이름:" + list.get(i).getName());
				}
				if(list.size()==0) {
					System.out.println("검색결과가 없습니다.");
					return;
				}
			} 
			else {	
				System.out.println("데이터가 없습니다.");
			}

		} catch (Exception e) {
			System.out.println("JDBC 오류");
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

//if (rs != null) {
////System.out.println(rs.getArray(0));
//System.out.println("찾고자 하는 데이터가 있습니다.");
//} 
//else {
//System.out.println("데이터가 없습니다.");
//}
