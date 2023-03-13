package com.viaxlab.service;

import java.util.List;

import com.viaxlab.model.Product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name= "PRODUCT-SERVICE-SIMILAR", url = "localhost:3001")
public interface ProductApiService {
	
	@RequestMapping(value={"/product/{productId}"}, method= RequestMethod.GET)
	Product getProductById(@PathVariable ("productId") String id);
	
	
	@RequestMapping(value={"/product/{productId}/similarids"}, method= RequestMethod.GET)
	List<String> getProductsByIdSimilar(@PathVariable ("productId") String id);

	
	
	
}
