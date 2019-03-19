import static org.junit.Assert.*;
import org.junit.Test;
import exceptions.*;
import org.junit.Before;
import org.junit.Assert;

public class CoffeeMakerTest {

	CoffeeMaker cm= new CoffeeMaker();
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	
	@Before
	public void setUp() {
		
	}
	@Test
	public void testAddRecipe() {
		/**
		 * 1. 3개의 recipe만 추가
		 * 2. name, price, units of coffee, units of milk, units of sugar, and units of chocolate.
		 * 3. recipe name 유니크하다.
		 * 4. 가격은 int형(1~6)
		 * 5. 성공하면 message가 나오고, waiting state로 간다.
		 * */
	}

	@Test
	public void testDeleteRecipe() {
		/**
		 * 1. 존재하면 삭제
		 * 2. 이름으로 정렬
		 * 3. 성공하면 message가 나오고, waiting state로 간다.
		 * */
	}

	@Test
	public void testEditRecipe() {
		/**
		 * 1. 존재하면 수정
		 * 2. 이름으로 정렬
		 * 3. 레시피가 선택되면, 정보 입력
		 * 4. 이름은 변경되면 안됨
		 * 5. 성공하면 message가 나오고, waiting state로 간다.
		 * */
	}

	@Test
	public void testAddInventory() {
		/**
		 * 1. main menu에서 인벤토리 추가됨
		 * 2. 인벤토리 종류는 coffee, milk, sugar, and chocolate
		 * 3. 인벤토리 수치는 integer
		 * 4. 인벤토리는 beverage 살 때만 제거된다.
		 * 5. 성공하면 message가 나오고, waiting state로 간다.
		 * */
	}

	@Test
	public void testCheckInventory() {
		/**
		 * 1. main menu에서 인벤토리 체크
		 * 2. 성공하면 message가 나오고, waiting state로 간다.
		 * */
	}

	@Test
	public void testMakeCoffee() {
	}

	@Test
	public void testGetRecipes() {
	}

}
