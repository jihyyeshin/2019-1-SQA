//import static org.junit.Assert.*;
//import org.junit.Test;
//import exceptions.*;
//import org.junit.Before;
//import org.junit.Assert;
//
//public class example {
//
//	CoffeeMaker cm= new CoffeeMaker();
//	private Recipe r1;
//	private Recipe r2;
//	private Recipe r3;
//	private Recipe r4;
//
//	@Before
//	public void setUp() throws RecipeException {
//		r1=new Recipe();
//		r1.setName("latte");
//		r1.setPrice("4500");
//		r1.setAmtCoffee("4");
//		r1.setAmtMilk("5");
//		r1.setAmtSugar("3");
//		r1.setAmtChocolate("2");
//		
//		r2=new Recipe();
//		r2.setName("americano");
//		r2.setPrice("3500");
//		r2.setAmtCoffee("3");
//		r2.setAmtMilk("0");
//		r2.setAmtSugar("0");
//		r2.setAmtChocolate("0");
//		
//		r3=new Recipe();
//		r3.setName("Latte macciato");
//		r3.setPrice("5000");
//		r3.setAmtCoffee("3");
//		r3.setAmtMilk("3");
//		r3.setAmtSugar("2");
//		r3.setAmtChocolate("4");
//		
//		r4=new Recipe();
//		r4.setName("green tea");
//		r4.setPrice("4000");
//		r4.setAmtCoffee("0");
//		r4.setAmtMilk("2");
//		r4.setAmtSugar("3");
//		r4.setAmtChocolate("0");
//		
//		//super.setUp();
//	}
//
////	@Test
////	public void testAddRecipe() {
////		Recipe[] rbArray;
////		cm.addRecipe(r1);
////		rbArray=cm.getRecipes();
////		assertEquals("latte", rbArray[0].getName());
////		assertEquals(4500, rbArray[0].getPrice());
////		assertEquals(4, rbArray[0].getAmtCoffee());
////		assertEquals(5, rbArray[0].getAmtMilk());
////		assertEquals(3, rbArray[0].getAmtSugar());
////		assertEquals(2, rbArray[0].getAmtChocolate());	
////		
////		cm.addRecipe(r2);
////		rbArray=cm.getRecipes();
////		assertEquals("americano", rbArray[1].getName());
////		assertEquals(3500, rbArray[1].getPrice());
////		assertEquals(3, rbArray[1].getAmtCoffee());
////		assertEquals(0, rbArray[1].getAmtMilk());
////		assertEquals(0, rbArray[1].getAmtSugar());
////		assertEquals(0, rbArray[1].getAmtChocolate());		
////		
////		cm.addRecipe(r3);
////		rbArray=cm.getRecipes();
////		assertEquals("Latte macciato", rbArray[2].getName());
////		assertEquals(5000, rbArray[2].getPrice());
////		assertEquals(3, rbArray[2].getAmtCoffee());
////		assertEquals(3, rbArray[2].getAmtMilk());
////		assertEquals(2, rbArray[2].getAmtSugar());
////		assertEquals(4, rbArray[2].getAmtChocolate());		
////		
////		cm.addRecipe(r4);
////		rbArray=cm.getRecipes();
////		assertEquals("green tea", rbArray[3].getName());
////		assertEquals(4000, rbArray[3].getPrice());
////		assertEquals(0, rbArray[3].getAmtCoffee());
////		assertEquals(2, rbArray[3].getAmtMilk());
////		assertEquals(3, rbArray[3].getAmtSugar());
////		assertEquals(0, rbArray[3].getAmtChocolate());		
////	}
////	
//////	@Test
//////	public void testAddRecipeFail() {
//////		fail("Not yet implemented");
//////	}
////
////	@Test
////	public void testDeleteRecipe() {
////		cm.addRecipe(r1);
////		assertEquals("latte", cm.deleteRecipe(0));
////		cm.addRecipe(r2);
////		assertEquals("americano", cm.deleteRecipe(1));
////		cm.addRecipe(r3);
////		assertEquals("Latte macciato", cm.deleteRecipe(2));
////		cm.addRecipe(r4);
////		assertEquals("green tea", cm.deleteRecipe(3));
////	}
////
//////	@Test
//////	public void testDeleteRecipeFail() {
//////		fail("Not yet implemented");
//////	}
////
////	@Test
////	public void testEditRecipe() {
////		cm.addRecipe(r1);
////		cm.editRecipe(0, r3);
////		Recipe[] rbArray=cm.getRecipes();
////		assertEquals("Latte macciato", rbArray[0].getName());
////		assertEquals(5000, rbArray[0].getPrice());
////		assertEquals(3, rbArray[0].getAmtCoffee());
////		assertEquals(3, rbArray[0].getAmtMilk());
////		assertEquals(2, rbArray[0].getAmtSugar());
////		assertEquals(4, rbArray[0].getAmtChocolate());		
////		
////		cm.editRecipe(0, r4);
////		rbArray=cm.getRecipes();
////		assertEquals("green tea", rbArray[0].getName());
////		assertEquals(4000, rbArray[0].getPrice());
////		assertEquals(0, rbArray[0].getAmtCoffee());
////		assertEquals(2, rbArray[0].getAmtMilk());
////		assertEquals(3, rbArray[0].getAmtSugar());
////		assertEquals(0, rbArray[0].getAmtChocolate());	
////	}
////	
//////	@Test
//////	public void testEditRecipeFail() {
//////		fail("Not yet implemented");
//////	}
//
//	@Test
//	public void testAddInventory() {
//		String expected="Coffe: 19\n"+
//					"Milk: 22\n"+
//					"Sugar: 18\n"+
//					"Chocolate: 24\n";
//		try {
//			cm.addInventory("4", "7", "3", "9");
//		}catch(InventoryException e) {
//			fail("InventoryException should not be thrown");
//		}
//	}
//	
////	@Test
////	public void testAddInventoryFail() {
////		fail("Not yet implemented");
////	}
////
////	@Test
////	public void testCheckInventory() {
////		Assert.assertEquals("Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n",cm.checkInventory());
////	}
////	
//////	@Test
//////	public void testCheckInventoryFail() {
//////		fail("Not yet implemented");
//////	}
////
////	@Test
////	public void testMakeCoffee() {
////		String expectedR1="Coffe: 11\n"+
////				"Milk: 10\n"+
////				"Sugar: 12\n"+
////				"Chocolate: 13\n";
////		String expectedR2="Coffe: 5\n"+
////				"Milk: 10\n"+
////				"Sugar: 12\n"+
////				"Chocolate: 13\n";
////		cm.addRecipe(r1);
////		assertEquals(3000, cm.makeCoffee(0, 7500));
////		assertEquals(expectedR1, cm.checkInventory());
////		cm.addRecipe(r2);
////		assertEquals(3500, cm.makeCoffee(1, 7000));
////		assertEquals(expectedR2, cm.checkInventory());
////	}
////	
//////	@Test
//////	public void testMakeCoffeeFail() {
//////		fail("Not yet implemented");
//////	}
////
////	@Test
////	public void testGetRecipes() {
////		fail("Not yet implemented");
////	}
////
//////	@Test
//////	public void testGetRecipesFail() {
//////		fail("Not yet implemented");
//////	}
//
//}
