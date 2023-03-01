package com.MyAplication.Utils;

public class Urls {

	public static final String HOST = "http://localhost:3001/";

    public static final String PRODUCT = "product";     
    
	public static final String GET_PRODUCT_SIMILAR_IDS = HOST + PRODUCT + "/{productId}/similarids";
	public static final String GET_PRODUCT_DETAIL = HOST + PRODUCT + "/{productId}";

    
}
