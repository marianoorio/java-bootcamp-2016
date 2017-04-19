package com.bootcamp.topic3.ServiceShoppingCart;

/**
 * Data Class for sale items
 *
 */
public class Item {
	private String itemId;
	private String itemDescription;
	private float itemPrice;
	private int itemStockQuantity;
	
	public Item(String itemId, String itemDescription, float itemPrice, int itemStockQuantity){
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

	public void setItemPrice(float itemPrice) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemDescription == null) ? 0 : itemDescription.hashCode());
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
		long temp;
		temp = Double.doubleToLongBits(itemPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + itemStockQuantity;
		return result;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Item other = (Item) obj;
		if (itemDescription == null) {
			if (other.itemDescription != null) {
				return false;
			}
		} else if (!itemDescription.equals(other.itemDescription)) {
			return false;
		}
		if (itemId == null) {
			if (other.itemId != null) {
				return false;
			}
		} else if (!itemId.equals(other.itemId)) {
			return false;
		}
		if (Double.doubleToLongBits(itemPrice) != Double.doubleToLongBits(other.itemPrice)) {
			return false;
		}
		if (itemStockQuantity != other.itemStockQuantity) {
			return false;
		}
		return true;
	}	
}
