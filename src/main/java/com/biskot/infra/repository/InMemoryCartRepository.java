package com.biskot.infra.repository;


import com.biskot.domain.model.Cart;
import com.biskot.domain.model.Item;
import com.biskot.domain.model.Product;
import com.biskot.domain.spi.CartPersistencePort;
import com.biskot.domain.spi.ProductPort;
import com.biskot.infra.gateway.ProductGateway;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component //a bean
public class InMemoryCartRepository implements CartPersistencePort {
    

	private static List<Cart> carts = new ArrayList<Cart>();
	private static int idCounter=0;
    private static String response; 

	 @Override
	 public List<Cart> getAllCarts(){
    	return carts;
    }
	 
	 
	 @Override
     public Cart getCart(int id) {
        
    	for(Cart cart:carts) {
			if(cart.getId()==id) {
				return cart;
			}
		}
		return null;
         }

    @Override
    public void saveCart(Cart cart) {
       
    	if(cart.getId()==-1 || cart.getId()==0) {
			cart.setId(++idCounter);
			cart.setItems(new ArrayList<Item>());
			carts.add(cart);
		}
		
    }
    
    
    private static List<Product> products= new ArrayList<Product>();
    @Autowired
    ProductPort productPort;
     
     @PostConstruct
     public void fillProductLst() {
    	products=productPort.getAllPoducts();
    }
    
   
     
     public void FindItemByProductId(int cartId,int product_id,int quantite) {
    	
    	 for(Item item: carts.get(cartId-1).getItems()) {
    		 if (item.getProduct_id()==product_id) 
  
    		 carts.get(cartId-1).getItems().remove(item);
    		 carts.get(cartId-1).setTotalPrice(carts.get(cartId-1).getTotalPrice()-item.getUnit_price()*quantite );
    		 break;
         }
    	 
     }
     
     @Override
     public void putItemToCart(int cartId, int product_id, int quantite) {
     	
    	FindItemByProductId(cartId,product_id,quantite);
     	addItemToCart(cartId,product_id-1,quantite);
     }
      
     @Override
    public void addItemToCart(int cartId, int product_id, int quantite) {
    
       Product product =products.get(product_id);
       
       if(product.getQuantity_in_stock()>quantite && 
    		   (carts.get(cartId-1).getTotalPrice()+product.getUnit_price()*quantite)<=100) {// toal_price + the new price < 100 
    	  Item item = new Item();
    	  item.setProduct_id(product.getId());
    	  item.setQuantity(quantite);
    	  item.setProduct_label(product.getLabel());
    	  item.setUnit_price(product.getUnit_price());
    	  
    	  carts.get(cartId-1).getItems().add(item);
    	  carts.get(cartId-1).setTotalPrice(totalPrice(carts.get(cartId-1).getItems()));
    	
    	  product.setQuantity_in_stock(product.getQuantity_in_stock()-quantite);
    	  /*test*/System.out.println("Added");
          response="Added";
       }else if(product.getQuantity_in_stock()==0) {
    	   /*test*/  System.out.println("No Product in Stock or Total Price must be less than 100");
    	   response="No Product in Stock or Total Price must be less than 100";
       }else if(product.getQuantity_in_stock()<quantite){
    	/*test*/System.out.println("There is "+product.getQuantity_in_stock()+"in Stock ");
    	   response="There is " +product.getQuantity_in_stock()+ " product in Stock ";
       }else if((carts.get(cartId-1).getTotalPrice()+product.getUnit_price()*quantite)>100) { // toal_price + the new price > 100 
    	   System.out.println("Total Price must be less than 100");
    	   response="Total Price must be less than 100";
       
       }
     
    }
     
 
    public double totalPrice(List<Item> items) {
  	  double sum=0;
  	  for(Item item:items) {
  		sum=sum+(item.getUnit_price()*item.getQuantity());
  	  }
  	  return sum;
  	}


	public static String getResponse() {
		return response;
	}


	public static void setResponse(String response) {
		InMemoryCartRepository.response = response;
	}

    

	
    
}