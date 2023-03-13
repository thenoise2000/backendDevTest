package com.viaxlab.service;

import java.util.List;

import com.viaxlab.model.Product;


public interface ProductService {

	public Product getProductById(String id);
	
	public List<Product> getProductS(String id);
}
