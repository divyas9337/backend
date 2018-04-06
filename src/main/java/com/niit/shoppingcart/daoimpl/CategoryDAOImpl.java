package com.niit.shoppingcart.daoimpl;


import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;

@Transactional
@Repository("categoryDAO") 
public class CategoryDAOImpl implements CategoryDAO {

	//first -inject hibernate session 
	//@Autowire
	@Autowired //session factory will automatically inject in this class
	 SessionFactory sessionFactory;
	@SuppressWarnings("unused")
	@Autowired
	private Category category;
	@SuppressWarnings("unused")
	private Restrictions Restrictions;
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
		
	}
	public boolean save(Category category) {
		try {
			Session session=sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			
			session.saveOrUpdate(category);
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
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Category> list() {
		// TODO Auto-generated method stub
		//return  (List<Category>) sessionFactory.openSession().createQuery("from Category").list();
		
		return (List<Category>)
				  sessionFactory.openSession()
				.createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		}
	}
		
	
	

		






