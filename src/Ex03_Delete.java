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
		System.out.println("������ id�� �Է����ּ��� >> ");
		String id = sc.next();
		// delete�������
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			String sql = "delete from mem where mem_id = ?";

			// DB�� �����ϱ� ���� sql�� ���!
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			int row = psmt.executeUpdate();

			System.out.println(row);
			if (row > 0) {
				System.out.println("������ delete ����!!!!!");
			} else {
				System.out.println("������ delete ����!!!!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("�������");
			e.printStackTrace();
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("�ݳ�����");
				e.printStackTrace();
			}
		}
	}
}
