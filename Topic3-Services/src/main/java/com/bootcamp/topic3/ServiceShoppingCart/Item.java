package com.bootcamp.topic3.ServiceShoppingCart;

/**
 * 
 * 
 *
 */
public class Item {
	private String itemId;
	private String itemDescription;
	private double itemPrice;
	private int itemStockQuantity;
	
	public Item(String itemId, String itemDescription, double itemPrice, int itemStockQuantity){
		this.itemId = itemId;
		this.itemDescription = itemDescription;
		this.itemPrice = itemPrice;
		this.itemStockQuantity = itemStockQuantity;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemStockQuantity() {
		return itemStockQuantity;
	}

	public void setItemStockQuantity(int itemStockQuantity) {
		this.itemStockQuantity = itemStockQuantity;
	}

	public String getItemId() {
		return itemId;
	}
	
}
