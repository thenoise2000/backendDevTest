package com.viaxlab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;

import com.viaxlab.model.Product;
import com.viaxlab.service.impl.ProductServiceI;

import feign.FeignException.FeignClientException;

@RestController
public class ProductController {

	@Autowired
	ProductServiceI productService;
	
	@RequestMapping(value={"/product/{productId}"}, method= RequestMethod.GET)
	public ResponseEntity<Product> getPro(@PathVariable ("productId") String id) throws FeignClientException{
		try{
			return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK) ;
		}catch(FeignClientException e) {
			throw  e;
		}
	}
	
	@RequestMapping(value={"/product/{productId}/similar"}, method= RequestMethod.GET)
	public ResponseEntity<List<Product>> getProdSimilar(@PathVariable ("productId") String id) throws FeignClientException{
		try{
			return new ResponseEntity<>(productService.getProductS(id), HttpStatus.OK) ;
		}catch(FeignClientException f) {
			throw  f;
		}
	}
	
	
	
}
