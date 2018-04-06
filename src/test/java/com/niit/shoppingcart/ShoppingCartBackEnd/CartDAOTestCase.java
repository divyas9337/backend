/*package com.niit.shoppingcart.ShoppingCartBackEnd;

import static org.junit.Assert.*;


import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;

public class CartDAOTestCase {
private static AnnotationConfigApplicationContext context;
@Autowired
private static CartDAO cartDAO;
@Autowired
private static Cart cart;
@BeforeClass
public static void init() {
	context=new AnnotationConfigApplicationContext();
	context.scan("com.niit.shoppingcart");
	context.refresh();
	cartDAO=(CartDAO)context.getBean("cartDAO");
	cart=(Cart)context.getBean("cart");
}
@Test
public void saveCartTestCase() {
	cart.setId("Lakme001");
	boolean status=cartDAO.save(cart);
	assertEquals("save your test case", true,status);
}
}
*/