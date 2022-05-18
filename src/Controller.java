import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {
	// main���� ȣ���ϴ� ��ɵ��� �����Ҽ� �ִ� Ŭ����

	// ��� �޼ҵ忡�� ��ü�� ����� �� �ֵ��� �������� ����!
	PreparedStatement psmt = null;
	Connection conn = null;
	ResultSet rs = null;
	
	// ��� �������� ���� �� �ִ� ���� ����
	int row = 0;
	
	// JDBC ������ ���� �޼ҵ� ����! => getCon()
	public void getCon() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr"; // �����ͺ��̽� ����
			String password = "hr"; // ��й�ȣ
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
//��ü�� �ݾ��ټ� �ִ� close() ����
	public void close() {
		try {
			if(rs != null) rs.close();
			
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("�ݳ� ����");
			e.printStackTrace();
		}
	}

	// jdbc �����ϱ� ���� �޼ҵ�
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
			System.out.println("���� ����");
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
