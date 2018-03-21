package com.niit.shoppingcart.ShoppingCartBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;


public class ProductDAOTestCase {
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static ProductDAO productDAO;
	@Autowired
	private static Product product;
	@BeforeClass
	public static void init() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart"); 
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		product=(Product)context.getBean("product");
	}

	@Test
	public void saveProductDAOTestCase() {
		product.setId("Lenovo 001");
		product.setName("Lenovo...Product");
		product.setDescription("This is Lenovo Product");
		product.setCategoryID("Mobile001");
		product.setSupplierID("Divyas9337");
		boolean status=productDAO.save(product);
		assertEquals("save your test case",true,status);
		
		
		
	}

}
