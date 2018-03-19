
package com.niit.shoppingcart.daoimpl;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;

@Repository //will create instance of UserDAOImpl and the name will userDAOImpl
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private Product product;
	private Restrictions Restrictions;
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public boolean save(Product product) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(product);
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;
	}

	public boolean update(Product product) {
		sessionFactory.openSession().update(product);
		sessionFactory.close();
		// TODO Auto-generated method stub
		return true;
	}

	public Product get(String id) {
		Product product=sessionFactory.getCurrentSession().load(Product.class, id);
		// TODO Auto-generated method stub
		return product;
	}

	public boolean delete(String id) {
		try {
			Session session=sessionFactory.openSession();
			Product product=(Product)session.get(Product.class, id);
			Transaction tx=session.beginTransaction();
			session.delete(product);
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;
	}

	public Set<Product> set() {
		
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}