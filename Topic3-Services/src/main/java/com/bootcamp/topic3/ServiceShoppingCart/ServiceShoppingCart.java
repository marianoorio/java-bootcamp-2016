package com.bootcamp.topic3.ServiceShoppingCart;

import java.util.List;

/**
 * 
 * Interface for a shopping cart service
 *
 */
public interface ServiceShoppingCart {
	
	/**
	 * 
	 * @param item new item to add
	 * @param quantity of the item
	 * @return true if it is added / false otherwise
	 */
	public boolean addToCart(Item item, int quantity);
	
	/**
	 * 
	 * @param item to update
	 * @param quantity new quantity of the item
	 * @return true if it is modified / false otherwise
	 */
	public boolean updateItemQuantity(Item item, int quantity);
	
	/**
	 * 
	 * @param item to remove
	 * @return true if it is removed / false otherwise
	 */
	public boolean removeItem(Item item);
	
	/**
	 * 
	 * @return a list of all items
	 */
	public List<Item> getAllItems();
	
	/**
	 * 
	 * @param item to want know quantity in the cart
	 * @return the quantity of the item in the cart
	 */
	public int getItemQuantity(Item item);
	
	/**
	 * 
	 * @return the price of all products in the cart
	 */
	public double getTotalPrice();
	
	/**
	 * 
	 * @return true if the cart is empty / false otherwise
	 */
	public boolean isEmpty();
}
