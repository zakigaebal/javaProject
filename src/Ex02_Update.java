import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex02_Update {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// �����ϱ�
		Connection conn = null;
		// �غ���
		PreparedStatement psmt = null;
		
		// user interface
		System.out.println("Id�� �Է����ּ��� >> ");
		String id = sc.next();
		System.out.println("������ pw�� �Է����ּ��� >> ");
		String pw = sc.next();
		System.out.println("������ name�� �Է����ּ��� >> ");
		String name = sc.next();
		
		
		//update�������
		try {
			// 1. class.forName
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. url, user, password
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr"; // �����ͺ��̽� ����
			String password = "hr"; // ��й�ȣ
			conn = DriverManager.getConnection(url,user,password);
						
			// 3. sql�� �غ�
			String sql = "update mem " + "set mem_pw = ?, mem_name =? where mem_id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, pw);
			psmt.setString(2, name);
			psmt.setString(3, id);
			int row = psmt.executeUpdate();
			if(row>0) {
				System.out.println("������ update ����!!!!");
			}
			//
			else {
				System.out.println("������ update ����!!!!");
			}			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		finally {
			try {
				// 4. �ڿ��ݳ�
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println("�ݳ� ����");
				e.printStackTrace();
			}
		}
	}

}
