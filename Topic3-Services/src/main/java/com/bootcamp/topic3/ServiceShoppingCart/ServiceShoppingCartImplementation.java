package com.bootcamp.topic3.ServiceShoppingCart;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
		if(item == null || cartItems.containsKey(item.getItemId())){
			//if the cart allow to update quantity on existing add it must be here
			return false;
		}else{
			ItemCart itemCart = new ItemCart(item,quantity);
			cartItems.put(item.getItemId(), itemCart);
			return true;
		}
	}

	@Override
	public boolean updateItemQuantity(Item item, int quantity) {
		if(item == null || !cartItems.containsKey(item.getItemId())){
			return false;
		}else{
			cartItems.get(item.getItemId()).updateQuantity(quantity);
			return true;
		}
	}

	@Override
	public boolean removeItem(Item item) {
		if(item != null && cartItems.containsKey(item.getItemId())){
			cartItems.remove(item.getItemId());
			return true;
		}else{
			return false;
		}
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
		if (item != null && cartItems.containsKey(item.getItemId())){
			return cartItems.get(item.getItemId()).getQuantity();
		}
		return 0;
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
