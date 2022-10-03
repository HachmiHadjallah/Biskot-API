package com.biskot.infra.repository.entity;

import java.util.Objects;

public class ItemEntity {
    // TODO: to be implemented
	
	 private int product_id;
	 private String product_label;
	 private int quantity;
	 private double unit_price;
	 private double line_price;
	public ItemEntity(int product_id, String product_label, int quantity, double unit_price, double line_price) {
		super();
		this.product_id = product_id;
		this.product_label = product_label;
		this.quantity = quantity;
		this.unit_price = unit_price;
		this.line_price = line_price;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_label() {
		return product_label;
	}
	public void setProduct_label(String product_label) {
		this.product_label = product_label;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	public double getLine_price() {
		return line_price;
	}
	public void setLine_price(double line_price) {
		this.line_price = line_price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(line_price, product_id, product_label, quantity, unit_price);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemEntity other = (ItemEntity) obj;
		return Double.doubleToLongBits(line_price) == Double.doubleToLongBits(other.line_price)
				&& product_id == other.product_id && Objects.equals(product_label, other.product_label)
				&& quantity == other.quantity
				&& Double.doubleToLongBits(unit_price) == Double.doubleToLongBits(other.unit_price);
	}
	@Override
	public String toString() {
		return "ItemEntity [product_id=" + product_id + ", product_label=" + product_label + ", quantity=" + quantity
				+ ", unit_price=" + unit_price + ", line_price=" + line_price + "]";
	}
	 
	 
	
	// TODO: to be implemented

}
