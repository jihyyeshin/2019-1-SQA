import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import junit.framework.TestCase;

class LETest {

	private File_Buffer FILE;
	private Init_Exit Start_End;
	private Cmd_Driver Run_Command;
	private UserCmd commandLineTokens;
	private boolean done;
	private String[] args = { "text.txt", };
	private ArrayList<String> txt = new ArrayList<String>();

	private boolean UPDATE_FILE = true;

	@BeforeEach
	void setUp() throws Exception {
		FILE = new File_Buffer();
		Start_End = new Init_Exit(args, FILE);
		Run_Command = new Cmd_Driver();
		done = false;
		txt.add("@City of stars");
		txt.add("Are you shining just for me stars");
		txt.add("City of Stars,");
	}

	// top�� 1�� �������� Ȯ��
	@Test
	void testCmd_T() {
		Run_Command.Cmd_T(FILE);
		assertEquals(1, FILE.GetCLN());
	}

	@Test
	void testCmd_E() {
		int testCLN = FILE.NumLins();// ������ ����
		Run_Command.Cmd_E(FILE);
		assertEquals(testCLN, FILE.GetCLN());
	}

	@Test
	void testCmd_N() {
		int testCLN = FILE.GetCLN();// ���� cln
		Run_Command.Cmd_N(FILE, 3);
		// �ִ� ���̺��� ���
		if (testCLN + 3 > FILE.NumLins()) testCLN = FILE.NumLins();
		else testCLN += 3;
		assertEquals(testCLN, FILE.GetCLN());
	}

	@Test
	void testCmd_B() {
		int testCLN = FILE.GetCLN();// ���� cln
		Run_Command.Cmd_B(FILE, 3);
		// 1���� ������
		if (testCLN - 3 < 1) testCLN = 1;
		else testCLN -= 3;
		assertEquals(testCLN, FILE.GetCLN());
	}

	@Test
	void testCmd_W() {
		// ó�� ������ �Ŀ� w ��ɾ ���� 1�� ���;� �Ѵ�.
		Run_Command.Cmd_W(FILE);
		assertEquals("At Edit File Line 1", "At Edit File Line " + FILE.GetCLN());
	}

	@Test
	void testCmd_C() {
		// ��ü line: 12��
		Run_Command.Cmd_C(FILE);
		assertEquals("Total Edit File Lines: 8", "Total Edit File Lines: " + FILE.NumLins());
	}

	@Test
	void testCmd_L() {
		// txt: ���� �ؽ�Ʈ ���� ����
		// �׽�Ʈ �� ���� - �ؽ�Ʈ ���Ͽ��� ���� ������
		ArrayList<String> test = new ArrayList<String>();
		int start = FILE.GetCLN();
		int end;
		if (start + 2 > FILE.NumLins()) end = FILE.NumLins();
		else
			end = start + 2;
		for (int i = start; i <= end; i++)
			test.add(FILE.GetLine(i));
		// ���� ��, ���� ������ ����Ʈ�� ������ �ִ��� �׽�Ʈ
		assertTrue(txt.containsAll(test));
	}

	@Test
	void testCmd_S() {
		// �׽�Ʈ �� ���� - �ؽ�Ʈ ���Ͽ��� ���� ������
		ArrayList<String> test = new ArrayList<String>();
		int start = FILE.GetCLN();
		int end;
		if (start + 2 > FILE.NumLins()) end = FILE.NumLins();
		else
			end = start + 2;
		for (int i = start; i <= end; i++)
			test.add(FILE.GetLine(i));
		// ���� ��, ���� ������ ����Ʈ�� ������ �ִ��� �׽�Ʈ
		assertTrue(txt.containsAll(test));

		Run_Command.Cmd_S(FILE, 3);
		// CLN���� ������ ��ġ�� �ʱ� ������, ���� ��ȭ�ϸ� �ȵȴ�
		assertSame(start, FILE.GetCLN());
	}

	@Test
	void testCmd_D() {
		// ��ü �ؽ�Ʈ ���� �� ù ������ �����
		ArrayList<String> delTxt = new ArrayList<String>();
		delTxt.add("hello");
		delTxt.add("stars");
		delTxt.add("Are you shining just for me");
		delTxt.add("hello");
		delTxt.add("stars");

		// �׽�Ʈ �� ���� - �ؽ�Ʈ ���Ͽ��� ���� ������
		ArrayList<String> test = new ArrayList<String>();
		Run_Command.Cmd_D(FILE, 3);
		for (int i = FILE.GetCLN(); i <= FILE.NumLins(); i++) {
			test.add(FILE.GetLine(i));
		}
		/*
		 * ������ �� ù ������ ������� ��ɾ ������, ���ٹۿ� �������� ���� ; �ذ�
		 */
		assertEquals(delTxt, test);
	}

	@Test
	void testCmd_A() {
//		int prevCln=FILE.GetCLN();
//		int prevTotal=FILE.NumLins();
//		try {
//			Run_Command.Cmd_A(FILE);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		//���� ���� test
//		assertEquals(prevCln+1, FILE.GetCLN());
//		assertEquals(prevTotal+1, FILE.NumLins());
	}

	@Test
	void testCmd_F() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_F(FILE, 5, "stars");
		/*
		 * ���� �߻� ������ ����5���� �ϴµ�, 6���� ���´�. ; �ذ�
		 */
		assertEquals(prevCln+4, FILE.GetCLN());
	}

	@Test
	void testCmd_R() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_R(FILE, 5, "of", "at");
		// �ٲ� ��, CLN�� ����� �ٲ�� �ִ��� Ȯ��
		assertEquals(prevCln + 4, FILE.GetCLN());
	}

	@Test
	void testCmd_Y() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_Y(FILE, 3);
		// ������ ��, CLN�� ����� �ٲ�� �ִ��� Ȯ��
		assertEquals(prevCln + 2, FILE.GetCLN());
	}

	@Test
	void testCmd_Z() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_Z(FILE, 3);
	}

	@Test
	void testCmd_P() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_Y(FILE, 3);
		Run_Command.Cmd_P(FILE);
		// copy�ؼ� �ٿ��ֱ� ������ test�̱� ������, ����� CLN�� �ٲ������ Ȯ��
		assertEquals(prevCln + 3 * 2 - 1, FILE.GetCLN());
	}

	@Test
	void testCmd_I() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_I(FILE);
		// CLN��ȭ ������ Ȯ��
		assertEquals(prevCln, FILE.GetCLN());
	}

	@Test
	void testCmd_K() {
		int prevCln = FILE.GetCLN();
		// index���̺����
		Run_Command.Cmd_I(FILE);
		Run_Command.Cmd_K("City");
		// CLN��ȭ ������ Ȯ��
		assertEquals(prevCln, FILE.GetCLN());
	}

	@Test
	void testCmd_O() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_O(FILE, 3);
		// ������ ��, CLN�� ����� �ٲ�� �ִ��� Ȯ��
		assertEquals(prevCln + 2, FILE.GetCLN());
	}

	@Test
	void testCmd_M() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_M(1, 2);
		// CLN��ȭ ������ Ȯ��
		assertEquals(prevCln, FILE.GetCLN());
	}

}
