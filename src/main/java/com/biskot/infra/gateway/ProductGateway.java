package com.biskot.infra.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.biskot.domain.model.Product;
import com.biskot.domain.spi.ProductPort;

@Component
public class ProductGateway implements ProductPort {

    private static List<Product> products= new ArrayList<Product>();

    static {
    	products.add(new Product(1,"Déodorant Spray 200ml Ice Dive ADIDAS",2.00,200));
    	products.add(new Product(2,"Huile d'Argan BIO - 1L",49.99,21));
    	products.add(new Product(3,"Crème Visage Bio Premières Rides",10.40,20));
    	products.add(new Product(4,"Vin Rouge, Château Peyrabon 1964",79.00,3));
    	products.add(new Product(5,"TestProduct",2.1,3));
    }
	
	public Product getProduct(int productId) {
        
        return products.get(productId-1);
    }
	
	public List <Product> getAllPoducts(){
		return products;
	}

}
