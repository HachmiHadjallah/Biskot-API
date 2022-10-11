package com.biskot.infra.repository.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartEntity {
    // TODO: to be implemented
    
	private int id;
	private List<ItemEntity> items = new ArrayList<ItemEntity>();
	private double totalPrice;
	public CartEntity(int id, List<ItemEntity> items, double totalPrice) {
		super();
		this.id = id;
		this.items = items;
		this.totalPrice = totalPrice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ItemEntity> getItems() {
		return items;
	}
	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, items, totalPrice);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartEntity other = (CartEntity) obj;
		return id == other.id && Objects.equals(items, other.items)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}
	@Override
	public String toString() {
		return "CartEntity [id=" + id + ", items=" + items + ", totalPrice=" + totalPrice + "]";
	}
	
	
	
	
	
	
	 
	// TODO: to be implemented

	
}
