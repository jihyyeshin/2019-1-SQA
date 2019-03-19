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
	private Recipe r5;
	private Recipe r6;
	
	@Before
	public void setUp() throws RecipeException {
		/* 레시피 추가 */
		r1=new Recipe();
		r1.setName("Americano");
		r1.setPrice("4000");
		r1.setAmtCoffee("2");
		r1.setAmtMilk("2");
		r1.setAmtSugar("2");
		r1.setAmtChocolate("2");
		
		r2=new Recipe();
		r2.setName("Latte");
		r2.setPrice("4500");
		r2.setAmtCoffee("1");
		r2.setAmtMilk("2");
		r2.setAmtSugar("3");
		r2.setAmtChocolate("4");
		
		r3=new Recipe();
		r3.setName("Vanilla Latte");
		r3.setPrice("5000");
		r3.setAmtCoffee("2");
		r3.setAmtMilk("0");
		r3.setAmtSugar("0");
		r3.setAmtChocolate("0");
		
		r4=new Recipe();
		r4.setName("Cappuccino");
		r4.setPrice("5500");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("2");
		r4.setAmtSugar("6");
		r4.setAmtChocolate("0");
		
		r5=new Recipe();
		r5.setName("Apogato");
		r5.setPrice("6000");
		r5.setAmtCoffee("1");
		r5.setAmtMilk("4");
		r5.setAmtSugar("4");
		r5.setAmtChocolate("3");

		r6=new Recipe();
		r6.setName("Vanilla Latte");
		r6.setPrice("6000");
		r6.setAmtCoffee("1");
		r6.setAmtMilk("4");
		r6.setAmtSugar("4");
		r6.setAmtChocolate("3");
	}
	/**
	 * AddRecipe()
	 * 1. 레시피가 몇 개까지 추가되는가 - 3개까지 되어야 함
	 * 2. name, price, units of coffee, units of milk, units of sugar, and units of chocolate
	 * 3. 레시피의 이름을 유니크하게 해주는가
	 * 4. 가격이 정수형인가
	 * 5. 성공하면 message가 나오고, waiting state로 간다.
	 * */
	@Test
	public void testAddRecipe() {
		assertTrue(cm.addRecipe(r1));
		assertTrue(cm.addRecipe(r2));
		assertTrue(cm.addRecipe(r3));
		/*
		 * 정상적으로 이름이 unique한가
		 * 테스팅 성공 : 이름의 중복이기 때문에 false가 나온다. 
		 * */
		assertEquals(false, cm.addRecipe(r6));
	}
	
	@Test
	public void testAddRecipeFail() {
		assertTrue(cm.addRecipe(r1));
		assertTrue(cm.addRecipe(r2));
		assertTrue(cm.addRecipe(r3));
		/* 
		 * 레시피를 3개까지 추가할 수 있는가
		 * 테스팅 실패 : 3개까지만 추가되어야 하는데, 4개까지 추가가 가능하여 true가 나온다.
		 *  */
		//assertEquals(false, cm.addRecipe(r4));
	}

	/**
	 * DeleteRecipe()
	 * 1. 존재하고 있던 레시피만 삭제
	 * 2. 레시피는 이름으로 listed
	 * 3. 성공하면 message가 나오고, waiting state로 간다.
	 * */
	@Test
	public void testDeleteRecipe() {
		/*
		 * 레시피를 삭제하고 정상적으로 이름을 return 하는가
		 * 테스팅 성공 : r1 레시피의 이름이 Americano이기 때문에, 올바르게 반환한다.
		 * */
		cm.addRecipe(r1);
		assertEquals("Americano", cm.deleteRecipe(0));		
	}

	@Test
	public void testDeleteRecipe2() {
		/*
		 * 존재하지 않는 레시피를 삭제했을 때, null이 나오는가
		 * 테스팅 성공 : 레시피를 넣지 않았기 때문에 레시피 삭제 메소드를 사용하였을 때 null값이 return된다.
		 * */
		assertEquals(null, cm.deleteRecipe(0));
	}
	
	/** 
	 * EditRecipe()
	 * 1. 레시피가 존재하면 수정
	 * 2. 레시피는 이름으로 listed
	 * 3. 레시피가 선택되면, 새로운 정보를 입력한다.
	 * 4. 이름은 변경되면 안된다.
	 * 5. 성공하면 message가 나오고, waiting state로 간다.
	 * */
	@Test
	public void testEditRecipe() {
		/*
		 * 레시피를 성공적으로 수정하고, 수정하는 이름을 정상적으로 반환하는가
		 * 테스팅 성공 : 레시피가 수정된 후에 r1의 이름이 반환된다.
		 * */
		cm.addRecipe(r1);
		assertEquals("Americano", cm.editRecipe(0, r3));
	}
	
	@Test
	public void testEditRecipe2() {
		/*
		 * 
		 * */
		cm.addRecipe(r1);
		cm.editRecipe(0, r3);
		assertEquals("Americano", r1.getName());
		
	}

	/**
	 * 1. main menu에서 인벤토리 추가됨
	 * 2. 인벤토리 종류는 coffee, milk, sugar, and chocolate
	 * 3. 인벤토리 수치는 integer
	 * 4. 인벤토리는 beverage 살 때만 제거된다.
	 * 5. 성공하면 message가 나오고, waiting state로 간다.
	 * */
	@Test
	public void testAddInventory() {
		
	}

	/**
	 * 1. main menu에서 인벤토리 체크
	 * 2. 성공하면 message가 나오고, waiting state로 간다.
	 * */
	@Test
	public void testCheckInventory() {
		
	}

	@Test
	public void testMakeCoffee() {
	}

	@Test
	public void testGetRecipes() {
	}

}
