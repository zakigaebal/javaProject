import java.util.Scanner;

public class JDBCMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// [1]�߰� [2]���� [3]�˻� [4]Ż�� [5]����
		// ����ڰ� ����ϰ��� �ϴ� ��� �Է¹ޱ�
		// 5���� �ԷµǱ� ������ ��� �޴��� �ݺ��� �� �ִ� ���� ����!

		System.out.print("[1]�߰� [2]���� [3]�˻� [4]Ż�� [5]����");
		// ����ڰ� ����ϰ��� �ϴ� ��� �Է¹ޱ�
		// 5���� �ԷµǱ� ������ ��� �޴��� �ݺ��� �� �ִ� ���� ����!
		Scanner sc = new Scanner(System.in);
		// ������� ����� Ȯ���ϱ� ���� ��������
		int row =0;
		while (true) {
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("==ȸ�� ����==");
				System.out.println("ID�� �Է����ּ��� >> ");
				String id = sc.next();
				System.out.println("pw�� �Է����ּ��� >> ");
				String pw = sc.next();
				System.out.println("�̸��� �Է����ּ��� >> ");
				String name = sc.next();
				
				// insert �޼ҵ带 ȣ��!
				Controller controller = new Controller();
				row = controller.insert(id,pw,name);
				if (row > 0) {
					System.out.println("������ �߰� ����!!!!");
				} else {
					System.out.println("�߰� ����!!!!");
				}
			} 
			else if (menu == 2) {

			} else if (menu == 3) {

			} else if (menu == 4) {

			} else if (menu == 5) {
				System.out.println("���α׷��� ����˴ϴ�.");
				break;
			}

		}
	}

}
