package com.example.listview;

public class ListItem {
	
	String itemName,itemPrice;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public ListItem(String itemName, String itemPrice) { 
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

}
