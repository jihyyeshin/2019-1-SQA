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
		 * 1. 3���� recipe�� �߰�
		 * 2. name, price, units of coffee, units of milk, units of sugar, and units of chocolate.
		 * 3. recipe name ����ũ�ϴ�.
		 * 4. ������ int��(1~6)
		 * 5. �����ϸ� message�� ������, waiting state�� ����.
		 * */
	}

	@Test
	public void testDeleteRecipe() {
		/**
		 * 1. �����ϸ� ����
		 * 2. �̸����� ����
		 * 3. �����ϸ� message�� ������, waiting state�� ����.
		 * */
	}

	@Test
	public void testEditRecipe() {
		/**
		 * 1. �����ϸ� ����
		 * 2. �̸����� ����
		 * 3. �����ǰ� ���õǸ�, ���� �Է�
		 * 4. �̸��� ����Ǹ� �ȵ�
		 * 5. �����ϸ� message�� ������, waiting state�� ����.
		 * */
	}

	@Test
	public void testAddInventory() {
		/**
		 * 1. main menu���� �κ��丮 �߰���
		 * 2. �κ��丮 ������ coffee, milk, sugar, and chocolate
		 * 3. �κ��丮 ��ġ�� integer
		 * 4. �κ��丮�� beverage �� ���� ���ŵȴ�.
		 * 5. �����ϸ� message�� ������, waiting state�� ����.
		 * */
	}

	@Test
	public void testCheckInventory() {
		/**
		 * 1. main menu���� �κ��丮 üũ
		 * 2. �����ϸ� message�� ������, waiting state�� ����.
		 * */
	}

	@Test
	public void testMakeCoffee() {
	}

	@Test
	public void testGetRecipes() {
	}

}
