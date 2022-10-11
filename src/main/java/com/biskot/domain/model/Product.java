package com.biskot.domain.model;

public class Product {
    private int id;
    private String label;
    private double unit_price;
    private int quantity_in_stock;
	
    public Product(int id, String label, double unit_price, int quantity_in_stock) {
		super();
		this.id = id;
		this.label = label;
		this.unit_price = unit_price;
		this.quantity_in_stock = quantity_in_stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}

	public int getQuantity_in_stock() {
		return quantity_in_stock;
	}

	public void setQuantity_in_stock(int quantity_in_stock) {
		this.quantity_in_stock = quantity_in_stock;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", label=" + label + ", unit_price=" + unit_price + ", quantity_in_stock="
				+ quantity_in_stock + "]";
	}
    
    
}
