package com.bootcamp.topic3.ServiceShoppingCart;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

/**
 * 
 * Implementation for ServiceShoppingCart Interface
 *
 */
public class ServiceShoppingCartImplementation implements ServiceShoppingCart{
	
	/**
	 * 
	 * private class to store an item and its quantity
	 *
	 */
	private class ItemCart{
		private Item item;
		private int quantity;
		
		public ItemCart(Item item, int quantity){
			this.item = item;
			this.quantity = quantity;
		}
		
		public Item getItem(){
			return this.item;
		}
		
		public int getQuantity(){
			return this.quantity;
		}
		
		public void updateQuantity(int newQuantity){
			this.quantity = newQuantity;
		}

		public double getPrice() {
			return item.getItemPrice()*quantity;
		}
	}
	
	
	private Map<String, ItemCart> cartItems;
	
	public ServiceShoppingCartImplementation(){
		cartItems = new Hashtable<String, ItemCart>();
	}
	
	@Override
	public boolean addToCart(Item item, int quantity) {
		boolean added = false;
		if(item == null || cartItems.containsKey(item.getItemId())){
			added = false;
		}else{
			ItemCart itemCart = new ItemCart(item,quantity);
			cartItems.put(item.getItemId(), itemCart);
			added = true;
		}
		return added;
	}

	@Override
	public boolean updateItemQuantity(Item item, int quantity) {
		boolean updated;
		if(item == null || !cartItems.containsKey(item.getItemId())){
			updated = false;
		}else{
			cartItems.get(item.getItemId()).updateQuantity(quantity);
			updated = true;
		}
		return updated;
	}

	@Override
	public boolean removeItem(Item item) {
		boolean removed;
		if(item != null && cartItems.containsKey(item.getItemId())){
			cartItems.remove(item.getItemId());
			removed = true;
		}else{
			removed = false;
		}
		return removed;
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> itemList = new ArrayList<Item>();
		for (String key : cartItems.keySet()){
			itemList.add(cartItems.get(key).getItem());
		}
		return itemList;
	}

	@Override
	public int getItemQuantity(Item item) {
		int quantity = 0;
		if (item != null && cartItems.containsKey(item.getItemId())){
			quantity = cartItems.get(item.getItemId()).getQuantity();
		}
		return quantity;
	}
	
	@Override
	public double getTotalPrice() {
		double result = 0;
		for (String key : cartItems.keySet()){
			result += cartItems.get(key).getPrice();
		}
		return result;
	}

	@Override
	public boolean isEmpty() {
		return cartItems.isEmpty();
	}
}
