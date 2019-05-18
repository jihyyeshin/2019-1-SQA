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

	// top이 1로 나오는지 확인
	@Test
	void testCmd_T() {
		Run_Command.Cmd_T(FILE);
		assertEquals(1, FILE.GetCLN());
	}

	@Test
	void testCmd_E() {
		int testCLN = FILE.NumLins();// 마지막 라인
		Run_Command.Cmd_E(FILE);
		assertEquals(testCLN, FILE.GetCLN());
	}

	@Test
	void testCmd_N() {
		int testCLN = FILE.GetCLN();// 현재 cln
		Run_Command.Cmd_N(FILE, 3);
		// 최대 길이보다 길면
		if (testCLN + 3 > FILE.NumLins()) testCLN = FILE.NumLins();
		else testCLN += 3;
		assertEquals(testCLN, FILE.GetCLN());
	}

	@Test
	void testCmd_B() {
		int testCLN = FILE.GetCLN();// 현재 cln
		Run_Command.Cmd_B(FILE, 3);
		// 1보다 작으면
		if (testCLN - 3 < 1) testCLN = 1;
		else testCLN -= 3;
		assertEquals(testCLN, FILE.GetCLN());
	}

	@Test
	void testCmd_W() {
		// 처음 실행한 후에 w 명령어를 쓰면 1이 나와야 한다.
		Run_Command.Cmd_W(FILE);
		assertEquals("At Edit File Line 1", "At Edit File Line " + FILE.GetCLN());
	}

	@Test
	void testCmd_C() {
		// 전체 line: 12줄
		Run_Command.Cmd_C(FILE);
		assertEquals("Total Edit File Lines: 8", "Total Edit File Lines: " + FILE.NumLins());
	}

	@Test
	void testCmd_L() {
		// txt: 원래 텍스트 파일 내용
		// 테스트 할 내용 - 텍스트 파일에서 직접 가져옴
		ArrayList<String> test = new ArrayList<String>();
		int start = FILE.GetCLN();
		int end;
		if (start + 2 > FILE.NumLins()) end = FILE.NumLins();
		else
			end = start + 2;
		for (int i = start; i <= end; i++)
			test.add(FILE.GetLine(i));
		// 같은 양, 같은 내용의 리스트를 가지고 있는지 테스트
		assertTrue(txt.containsAll(test));
	}

	@Test
	void testCmd_S() {
		// 테스트 할 내용 - 텍스트 파일에서 직접 가져옴
		ArrayList<String> test = new ArrayList<String>();
		int start = FILE.GetCLN();
		int end;
		if (start + 2 > FILE.NumLins()) end = FILE.NumLins();
		else
			end = start + 2;
		for (int i = start; i <= end; i++)
			test.add(FILE.GetLine(i));
		// 같은 양, 같은 내용의 리스트를 가지고 있는지 테스트
		assertTrue(txt.containsAll(test));

		Run_Command.Cmd_S(FILE, 3);
		// CLN에는 영향을 끼치지 않기 때문에, 값이 변화하면 안된다
		assertSame(start, FILE.GetCLN());
	}

	@Test
	void testCmd_D() {
		// 전체 텍스트 파일 중 첫 세줄을 지운다
		ArrayList<String> delTxt = new ArrayList<String>();
		delTxt.add("hello");
		delTxt.add("stars");
		delTxt.add("Are you shining just for me");
		delTxt.add("hello");
		delTxt.add("stars");

		// 테스트 할 내용 - 텍스트 파일에서 직접 가져옴
		ArrayList<String> test = new ArrayList<String>();
		Run_Command.Cmd_D(FILE, 3);
		for (int i = FILE.GetCLN(); i <= FILE.NumLins(); i++) {
			test.add(FILE.GetLine(i));
		}
		/*
		 * 오류난 곳 첫 세줄을 지우고자 명령어를 썼으나, 두줄밖에 지워지지 않음 ; 해결
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
//		//라인 수를 test
//		assertEquals(prevCln+1, FILE.GetCLN());
//		assertEquals(prevTotal+1, FILE.NumLins());
	}

	@Test
	void testCmd_F() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_F(FILE, 5, "stars");
		/*
		 * 오류 발생 원래는 라인5여야 하는데, 6으로 나온다. ; 해결
		 */
		assertEquals(prevCln+4, FILE.GetCLN());
	}

	@Test
	void testCmd_R() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_R(FILE, 5, "of", "at");
		// 바꾼 후, CLN이 제대로 바뀌어 있는지 확인
		assertEquals(prevCln + 4, FILE.GetCLN());
	}

	@Test
	void testCmd_Y() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_Y(FILE, 3);
		// 복사한 후, CLN이 제대로 바뀌어 있는지 확인
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
		// copy해서 붙여넣기 까지의 test이기 때문에, 제대로 CLN이 바뀌었는지 확인
		assertEquals(prevCln + 3 * 2 - 1, FILE.GetCLN());
	}

	@Test
	void testCmd_I() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_I(FILE);
		// CLN변화 없는지 확인
		assertEquals(prevCln, FILE.GetCLN());
	}

	@Test
	void testCmd_K() {
		int prevCln = FILE.GetCLN();
		// index테이블생성
		Run_Command.Cmd_I(FILE);
		Run_Command.Cmd_K("City");
		// CLN변화 없는지 확인
		assertEquals(prevCln, FILE.GetCLN());
	}

	@Test
	void testCmd_O() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_O(FILE, 3);
		// 정렬한 후, CLN이 제대로 바뀌어 있는지 확인
		assertEquals(prevCln + 2, FILE.GetCLN());
	}

	@Test
	void testCmd_M() {
		int prevCln = FILE.GetCLN();
		Run_Command.Cmd_M(1, 2);
		// CLN변화 없는지 확인
		assertEquals(prevCln, FILE.GetCLN());
	}

}
