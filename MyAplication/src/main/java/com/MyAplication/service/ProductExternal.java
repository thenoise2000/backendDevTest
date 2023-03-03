package com.MyAplication.service;

import com.MyAplication.Utils.Urls;
import com.MyAplication.model.Product;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductExternal {	 
	   
	
    public String[] getProductsIds(String productId) {
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<String[]> response =
                    restTemplate.getForEntity(Urls.EXTERN + productId + Urls.SIMILAR,
                            String[].class);
            return response.getBody();
        } catch (Exception e){
            log.warn("getProductsIds:: similar product not exist", productId);
            return null;
        }
    }

    public Product getProductById(String productId) {
        RestTemplate restTemplate = new RestTemplate();
        try{
            ResponseEntity<Product> response = restTemplate.getForEntity(Urls.EXTERN + productId, Product.class);
            return response.getBody();
        } catch (Exception e){
            log.warn("getProductById:: not exist detail product with", productId);
            return null;
        }
    }

}
