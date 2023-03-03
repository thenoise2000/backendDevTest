package com.MyAplication.convert;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Convert {

	public static <T> List<T> convert(Class<? extends T> clazz, Collection<?> convert) {
	    List<T> result = new ArrayList<T>(convert.size());
	    for(Object object: convert)
	    	result.add(clazz.cast(object));
	    return result;
	}
}
