package com.niit.shoppingcart.dao;


import java.util.List;
import com.niit.shoppingcart.domain.Supplier;

//Data Access object-DAO 
public interface SupplierDAO {
	//declare the methods.
	//create new user
	public boolean save(Supplier supplier);
	//update the exist user
	public boolean update(Supplier supplier);
	//get the user details
	public Supplier  get(String id);
	//delete the user
	public boolean  delete(String id);
	//to get all the users
	public List<Supplier> list();
	//validate whether the credentials are correct or not
	

}
