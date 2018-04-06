package com.niit.shoppingcart.dao;


import java.util.List;
import com.niit.shoppingcart.domain.Product;


public interface ProductDAO {
	
	public boolean save(Product product);
	
	public boolean update(Product product);
	
	public  Product  get(String id);
	
	public boolean  delete(String id);
	
	public List<Product> list();
	
	
}
