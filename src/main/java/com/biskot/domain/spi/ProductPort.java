package com.biskot.domain.spi;

import java.util.List;

import org.springframework.stereotype.Component;

import com.biskot.domain.model.Product;

@Component
public interface ProductPort {

    Product getProduct(int productId);
    public List <Product> getAllPoducts();

}
