package com.niit.shoppingcart.daoimpl;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.domain.Cart;

@Transactional
@Repository("cartDAO")
public class CartDAOImpl implements CartDAO{
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unused")
	@Autowired 
	private Cart cart;
	@Autowired
	private Restrictions Restrictions;
	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}

	public boolean save(Cart cart) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.saveOrUpdate(cart);
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;
	}

	public boolean update(Cart cart) {
		sessionFactory.openSession().update(cart);
		sessionFactory.close();
		
		return true;
		
	}

	public Cart get(String id) {
		Cart cart=sessionFactory.getCurrentSession().load(Cart.class,id);
		// TODO Auto-generated method stub
		return cart;
	}

	public boolean delete(String id) {
		try {
			Session session=sessionFactory.openSession();
			Cart cart=session.get(Cart.class,id);
			Transaction tx=session.beginTransaction();
			session.delete(cart);
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;
	}

	@SuppressWarnings({ "deprecation", "unchecked", "static-access" })
	public List<Cart> list(String emailID) {
		
		// TODO Auto-generated method stub
		return sessionFactory.openSession()
				.createCriteria(Cart.class)
				.add(Restrictions.eq("emailID",emailID)).list();
	}
	

}
