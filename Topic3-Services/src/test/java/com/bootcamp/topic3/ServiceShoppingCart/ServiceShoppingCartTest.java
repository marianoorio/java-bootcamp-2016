package com.bootcamp.topic3.ServiceShoppingCart;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.bootcamp.topic3.ServiceShoppingCart.Item;
import com.bootcamp.topic3.ServiceShoppingCart.ServiceShoppingCartImplementation;

/**
 * 
 * Unit test for shopping cart service
 *
 */
public class ServiceShoppingCartTest {
	
	ServiceShoppingCart shopCart;
	
	@Before
	public void setUp() throws Exception {
		shopCart = new ServiceShoppingCartImplementation();
	}

	@After
	public void tearDown() throws Exception {
		shopCart = null;
	}

	@Test
	public void whenCreatesACartItIsEmpty() {
		shopCart = new ServiceShoppingCartImplementation();
		Assert.assertTrue(shopCart.isEmpty());
	}
	
	@Test
	public void whenAddsAnItemToCartItIsAdded() {
		Item item = new Item("Item0","test item", 00, 12 );
		shopCart.addToCart(item,3);
		Assert.assertEquals(item, shopCart.getAllItems().get(0));
	}
	
	@Test
	public void whenAddsAnItemToCartItIsAddedWithTheRightQuantity() {
		Item item = new Item("Item0","test item", 00, 12 );
		shopCart.addToCart(item,5);
		Assert.assertEquals(5, shopCart.getItemQuantity(shopCart.getAllItems().get(0)));
	}
	
	@Test
	public void whenAddsItemsToCartTheyAreAdded() {
		Item item0 = new Item("Item0","test item", 00f, 12 );
		shopCart.addToCart(item0,4);
		Item item1 = new Item("Item1","test item 1", 12.12f, 40);
		shopCart.addToCart(item1,12);
		Item item2 = new Item("Item2","test item 2", 123.1f, 14 );
		shopCart.addToCart(item2,11);
		Assert.assertEquals(3, shopCart.getAllItems().size());
	}
	
	@Test
	public void whenAddsAnNullitemItIsNotAdded() {
		Item item0 = null;
		Assert.assertFalse(shopCart.addToCart(item0, 11));
	}
	
	@Test
	public void whenUpdatesAnItemQuantityItIsSettedToTheNewQuantity() {
		Item item0 = new Item("Item2","test item", 00, 12 );
		shopCart.addToCart(item0,3);
		Item item1 = new Item("Item1","test item 1", 12.3f, 40);
		shopCart.addToCart(item1,12);
		shopCart.updateItemQuantity(item1, 5);
		Assert.assertEquals(5, shopCart.getItemQuantity(item1));
	}
	
	@Test
	public void whenDeletesAnExistentItemReturnTrue() {
		Item item0 = new Item("Item2","test item", 00, 12 );
		shopCart.addToCart(item0,3);
		Item item1 = new Item("Item1","test item 1", 12.3f, 40);
		shopCart.addToCart(item1,12);
		Assert.assertTrue(shopCart.removeItem(item1));
	}
	
	@Test
	public void whenDeletesAnInexistentItemReturnFalse() {
		Item item0 = new Item("Item2","test item", 00, 12 );
		shopCart.addToCart(item0,3);
		Item item1 = new Item("Item1","test item 1", 12.3f, 40);
		Assert.assertFalse(shopCart.removeItem(item1));
	}
	
	@Test
	public void whenGetAllItemsItReturnAListWithThem() {
		List<Item> compare = new ArrayList<Item>();
		Item item0 = new Item("Item0","test item", 00f, 12 );
		shopCart.addToCart(item0,4);
		compare.add(0,item0);
		Item item1 = new Item("Item1","test item 1", 23.3f, 40);
		shopCart.addToCart(item1,12);
		compare.add(0,item1);
		Item item2 = new Item("Item2","test item 2", 123.1f, 14 );
		shopCart.addToCart(item2,11);
		compare.add(0,item2);
		Item item3 = new Item("Item3","test item 3", 320f, 13 );
		shopCart.addToCart(item3,5);
		compare.add(0,item3);
		Item item4 = new Item("Item4","test item 4", 10.2f, 24);
		shopCart.addToCart(item4,7);
		compare.add(0,item4);
		Item item5 = new Item("Item5","test item 5", 1.99f, 11 );
		shopCart.addToCart(item5,2);
		compare.add(0,item5);
		Assert.assertEquals(compare, shopCart.getAllItems());
	}
	
	@Test
	public void whenGetTheTotalPriceItIsCalculated() {
		List<Item> compare = new ArrayList<Item>();
		Item item0 = new Item("Item0","test item", 2.5f, 12 );
		shopCart.addToCart(item0,2);//TotalPrice?=5
		compare.add(0,item0);
		Item item1 = new Item("Item1","test item 1", 2f, 40);
		shopCart.addToCart(item1,1);//TotalPrice?=7
		compare.add(0,item1);
		Item item2 = new Item("Item2","test item 2", 2.5f, 14 );
		shopCart.addToCart(item2,4);//TotalPrice?=17
		compare.add(0,item2);
		Item item3 = new Item("Item3","test item 3", 2f, 13 );
		shopCart.addToCart(item3,4);//TotalPrice?=25
		compare.add(0,item3);
		Item item4 = new Item("Item4","test item 4", 2.5f, 24);
		shopCart.addToCart(item4,3);//TotalPrice?=32.5
		compare.add(0,item4);
		Item item5 = new Item("Item5","test item 5", 2f, 11 );
		shopCart.addToCart(item5,1);//TotalPrice?=34.5
		compare.add(0,item5);
		Assert.assertEquals(Double.valueOf(34.5), Double.valueOf(shopCart.getTotalPrice()));
	}
}
