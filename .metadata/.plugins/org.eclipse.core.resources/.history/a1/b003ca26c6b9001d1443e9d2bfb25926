package com.MyAplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.MyAplication.Utils.Urls;
import com.MyAplication.convert.Convert;
import com.MyAplication.error.ProductException;
import com.MyAplication.model.Product;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {

	
	public List<Product> getProductsById(String id) throws ProductException{
		List<Product> p = new ArrayList<>();
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			List<Integer> s = Convert.convert(Integer.class, restTemplate.getForObject(Urls.GET_PRODUCT_SIMILAR_IDS.replace("{productId}", id), ArrayList.class));
			
			p = s	.stream()
					.map(c -> restTemplate.getForObject(Urls.GET_PRODUCT_DETAIL.replace("{productId}", c.toString()), Product.class))
					.collect(Collectors.toList());
			
		} catch (Exception e) {
			throw new ProductException("Ocurred Exception");
		}
		
		return p;
	}
}
