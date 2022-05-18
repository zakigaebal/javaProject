import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ex01_insert {

	public static void main(String[] args) {
		
		// �ֹٷ� ������ : class�� ���ุ �������� ����Ǵ� ������
		// ���ֹ߼� ������: ������ �����ص� �����ִ� ������
		
		Scanner sc = new Scanner(System.in);
		PreparedStatement psmt = null;
		Connection conn = null;
		
		System.out.println("ID�� �Է����ּ��� >> ");
		String id = sc.next();
		System.out.println("pw�� �Է����ּ��� >> ");
		String pw = sc.next();
		System.out.println("�̸��� �Է����ּ��� >> ");
		String name = sc.next();
		
		// 1. JDBC ---> ojdbc6.jar���� ��������
		// 1-1) ����̹� �����ε�
		// �����ϴ� ������ �ڷ����� �����Ǵ� ��
		// Class.forName(name);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// � �����ͺ��̽��� ����̹��� ������ �ò��� �����ִ� �ڵ�
			// ����
			// 1) ��Ÿ�ӿ���
				// by / zero
				// 1 / 0 ===>
			// 2) ������ ����
			
			// oracle.jdbc.driver ---> ��Ű��
			// OracleDriver ----> Ŭ����
			
			// url, id, pw
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			// jdbc:oracle:thin : ����̹�
			// @localhost : ip�ּ�
			// 1521 : ��Ʈ��ȣ
			// xe : db�̸�
			String user = "hr"; // �����ͺ��̽� ����
			String password = "hr"; // ��й�ȣ
						
			conn = DriverManager.getConnection(url,user,password);
			// 2. sql���� �غ�
			// 2-1) sql�� �����
			String sql = "insert into mem values(?, ?, ?)";
			// 2-2) sql�� ����
			psmt = conn.prepareStatement(sql);
			// ----> sql���� ��Ŀ� �°� ����ִ� ����
			
			// ? ���ڸ� ä�� �����ٰſ���!!!! <---- �Է¹��� �����ͷ� ä������
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			
			// ? ���ڰ� table�� �°� �� ä�������� Ȯ���ϱ�
			// ������ ���� ��(���̺�)�� �ִ��� Ȯ���� ���ִ� ���
			int row = psmt.executeUpdate();
			
			// row > 0 : ������ ���� ���̺��� �ִ�!!!!
			// �װ� �ƴ϶�� �����Ͱ� �Է��� �ȉ��.
			if(row>0) {
				System.out.println("������ �߰� ����!!!!");
			}
			else {
				System.out.println("������ �߰� ����!!!!");
			}
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("���� ����");
			e.printStackTrace();
		}
		finally {
			// �߰��� ���ܻ�Ȳ�� ������� �ѹ��� �� �����Ű�� ����� ����
			// 4. �ݱ�
			// ( ����� �ݴ�������� ����!!!1 �������� ����!!!!)
			try {
				//psmt�� �����ִٸ� �ݾ�����
				// psmt�� ���� �� ������ �� null���� �ƴ϶󤿸�
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println("�ݳ� ����");
				e.printStackTrace();
			}
		}
	}

}
