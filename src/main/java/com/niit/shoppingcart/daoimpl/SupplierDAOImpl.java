
package com.niit.shoppingcart.daoimpl;

import java.util.Set;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Repository //will create instance of UserDAOImpl and the name will userDAOImpl
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	private Supplier supplier;
	private Restrictions Restrictions;
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	public boolean save(Supplier supplier) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			session.save(supplier);
			tx.commit();
			session.clear();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return true;
	}
	public boolean update(Supplier supplier) {
		sessionFactory.openSession().update(supplier);
		sessionFactory.close();
		// TODO Auto-generated method stub
		return true;
	}
	public Supplier get(String id) {
		Supplier supplier=sessionFactory.getCurrentSession().load(Supplier.class,id);
		
		// TODO Auto-generated method stub
		
		return supplier;
	}
	public boolean delete(String id) {
		try {
			Session session=sessionFactory.openSession();
			Supplier supplier=(Supplier)session.get(Supplier.class, id);
			Transaction tx=session.beginTransaction();
			session.delete(supplier);
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
		return (Set<Product>) sessionFactory.openSession().createQuery("from Product").list();
	}

	

	

}