package com.niit.shoppingcart.ShoppingCartBackEnd;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

public class CategoryDAOTestCase {

	
		private static AnnotationConfigApplicationContext context;
		@Autowired
		private static CategoryDAO categoryDAO;
		@Autowired
		private static Category category;
		@BeforeClass
		public static void init() {
			context=new AnnotationConfigApplicationContext();
			context.scan("com.niit.shoppingcart"); 
			context.refresh();
			categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
			category=(Category)context.getBean("category");
		}
		@Test
		public void saveCategoryTestCase() {
			category.setId("Mob001");
			category.setName("Mobile");
			category.setDescription("this is Mobile category");
			
			boolean status=categoryDAO.save(category);
			assertEquals("save your test case",true,status);
		}
			
	}
		
		

