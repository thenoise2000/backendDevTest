package com.MyAplication.service;

import java.util.ArrayList;
import java.util.List;



import com.MyAplication.model.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService implements ProductServiceInterface {

	
	    @Autowired
	    private final ProductExternal productExternal;

	    
	    public List<Product> getProductS(String Id) {

	        if( Id == null) return null;

	        String[] s =  productExternal.getProductsIds(Id);
	        if( s == null) return null;

	        List<Product> r = new ArrayList<>();
	        for (String id : s) {
	           Product p = productExternal.getProductById(id);
	           if( p != null) {
	               r.add(p);
	           }
	        }

	        return r;
	    }
}
