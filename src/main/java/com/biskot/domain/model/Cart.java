package com.biskot.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.biskot.infra.repository.entity.CartEntity;
import com.biskot.infra.repository.entity.ItemEntity;

public class Cart {

	private int id;
	private List<Item> items = new ArrayList<Item>();
	private double totalPrice;
	public Cart(int id, List<Item> items, double totalPrice) {
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
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
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
		Cart other = (Cart) obj;
		return id == other.id && Objects.equals(items, other.items)
				&& Double.doubleToLongBits(totalPrice) == Double.doubleToLongBits(other.totalPrice);
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", items=" + items + ", totalPrice=" + totalPrice + "]";
	}
	
}
