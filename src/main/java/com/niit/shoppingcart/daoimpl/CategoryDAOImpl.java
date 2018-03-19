package com.niit.shoppingcart.daoimpl;


import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;


@Repository("categoryDAO") 
public class CategoryDAOImpl implements CategoryDAO {

	//first -inject hibernate session 
	//@Autowire
	@Autowired //session factory will automatically inject in this class
	 SessionFactory sessionFactory;
	@Autowired
	private Category category;
	private Restrictions Restrictions;
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
	}
	public boolean save(Category category) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.save(category);
			tx.commit();
			session.clear();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return true;
	}
	public boolean update(Category category) {
		sessionFactory.openSession().update(category);
		sessionFactory.close();
		
		return true;
	}
	public Category get(String id) {
		Category category=sessionFactory.getCurrentSession().load(Category.class,id);
		
			
		// TODO Auto-generated method stub
		return category;
	}
	public boolean delete(String id) {
		try {
			 
			 
			 Session session=sessionFactory.openSession();
			        Category category = (Category) session.get(Category.class,id);
			        Transaction tx=session.beginTransaction();
			        session.delete(category);
			        tx.commit();
			    } catch (Exception e) {
			        
			        e.printStackTrace();
			    }
			return true; 
		}
		
	public Set<Product> set() {
		// TODO Auto-generated method stub
		return (Set<Product>) sessionFactory.openSession().createQuery("from Product").list();
	}



		
}





