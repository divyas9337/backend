package com.niit.shoppingcart.dao;



import java.util.List;
import java.util.Set;

import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;


//Data Access object-DAO 
public interface CategoryDAO {
	//declare the methods.
	//create new user
	public boolean save(Category category);
	//update the exist user
	public boolean update(Category category);
	//get the user details
	public  Category  get(String id);
	//delete the user
	public boolean  delete(String id);
	//to get all the users
	public List<Category> list();
		
	
	
	
}

