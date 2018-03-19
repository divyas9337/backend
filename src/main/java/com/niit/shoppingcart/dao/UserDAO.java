package com.niit.shoppingcart.dao;



import java.util.List;

import com.niit.shoppingcart.domain.User;

//Data Access object-DAO 
public interface UserDAO {
	//declare the methods.
	//create new user
	public boolean save(User user);
	//update the exist user
	public boolean update(User user);
	//get the user details
	public  User  get(String emailID);
	//delete the user
	public boolean  delete(String emailID);
	//to get all the users
	public List<User> list();
	//validate whether the credentials are correct or not
	public User validate(String emailID,String password);

}
