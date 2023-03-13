package com.viaxlab.service.impl;


import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.viaxlab.model.Product;
import com.viaxlab.service.ProductApiService;
import com.viaxlab.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class ProductServiceI implements ProductService{

	@Autowired
	ProductApiService productApiService;

	@Override
	public Product getProductById(String id){
		return productApiService.getProductById(id);
	}
	
	@Override
	public List<Product> getProductS(String id) {
		return productApiService.getProductsByIdSimilar(id).stream().map(productApiService::getProductById).collect(Collectors.toList()); 
		
	}
}
