import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex_Select {

	public static void main(String[] args) {
		// JDBC ���ῡ �ʿ��� ��ü �����ϱ�
		// Connection, PreparedStatement
		DatabaseInfo di = new DatabaseInfo();
		ArrayList<UserList> list = new ArrayList<UserList>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);

		// ����ڷ� ���� ������ Ȯ���ϰ� ���� id�� �Է� �ޱ�
		// -> sql ���� => �Է¹��� id�� ���� �������(id, pw, name) ����ϱ�

		try {
			System.out.print("���̵� �Է� >> ");
			String inputId = sc.next();

			// 1. �����ε� => Class.forName()
			Class.forName(di.cname);
			// 2. DB ����
			String url = di.url;
			String user = di.user;
			String password = di.pw;
			conn = DriverManager.getConnection(url, user, password);
			// 3. sql ����
			String sql = "select * from mem";
			String sql2 = "select * from mem where mem_id=" + "'" + inputId + "'";
			// String sql = "select * from mem where mem_pw= '1111'";
			psmt = conn.prepareStatement(sql2);

			// sql�� ����(�ڡڡڡڡ�)
			rs = psmt.executeQuery();

			if (rs != null) {
				// ResultSet�� ��� ����� ArrayList�� ���
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

				// ����� ���
				for (int i = 0; i < list.size(); i++) {
					System.out.println("ȸ�����̵�:" + list.get(i).getId());
					System.out.println("ȸ�����:" + list.get(i).getPw());
					System.out.println("ȸ���̸�:" + list.get(i).getName());
				}
				if(list.size()==0) {
					System.out.println("�˻������ �����ϴ�.");
					return;
				}
			} 
			else {	
				System.out.println("�����Ͱ� �����ϴ�.");
			}

		} catch (Exception e) {
			System.out.println("JDBC ����");
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
//System.out.println("ã���� �ϴ� �����Ͱ� �ֽ��ϴ�.");
//} 
//else {
//System.out.println("�����Ͱ� �����ϴ�.");
//}
