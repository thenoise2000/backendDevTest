package com.MyAplication.controller;

import java.util.List;

import com.MyAplication.model.Product;
import com.MyAplication.service.ProductService;
import com.MyAplication.service.ProductServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

	@Autowired
    ProductServiceInterface productServiceInterface;

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @GetMapping("/{productId}/similar")
    public Object getProductSim(@PathVariable String productId) {        
        List<Product> p = productServiceInterface.getProductS(productId);

        if(p == null) {            
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("not Exist");
        }
        return ResponseEntity.ok(p);
    }
}
