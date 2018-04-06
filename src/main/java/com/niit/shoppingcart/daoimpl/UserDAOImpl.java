package com.niit.shoppingcart.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.User;

@Repository("userDAO") //will create instance of UserDAOImpl and the name will userDAOImpl
public class UserDAOImpl implements UserDAO {

	
	//@Autowire
	@Autowired //session factory will automatically inject in this class
	 SessionFactory sessionFactory;
	@SuppressWarnings("unused")
	@Autowired
	
	private User user;
	private Restrictions Restrictions;
	public UserDAOImpl(){}

	public UserDAOImpl(SessionFactory sessionFactory) {

     this.sessionFactory=sessionFactory;
	}

	
	
	public boolean save(User user) {
	 try {
		 user.setRole('C');
		 user.setRegisteredDate(new Date().toString());
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(user);
		tx.commit();
		session.clear();
		
	} catch (HibernateException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	} 
	 return true;
	}
	//

	public boolean update(User user) {
		//store in database
		sessionFactory.openSession().update(user);
		sessionFactory.close();
		// TODO Auto-generated method stub
		return true;
	}

    
	public User get(String emailID) {
		
		
	User user=sessionFactory.getCurrentSession().load(User.class,emailID);
	return user;
		
	}
	public boolean delete(String emailID) {
		 try {
			 
			 
		 Session session=sessionFactory.openSession();
		        User user = (User) session.get(User.class, emailID);
		        Transaction tx=session.beginTransaction();
		        session.delete(user);
		        tx.commit();
		    } catch (Exception e) {
		        
		        e.printStackTrace();
		    }
		return true; 
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<User> list() {
		return (List<User>)
		  sessionFactory.openSession()
		.createCriteria(User.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
		}

	@SuppressWarnings({ "deprecation", "static-access" })
	@Transactional
	public User validate(String emailID, String password) {
		
		return (User)sessionFactory.openSession().
				createCriteria(User.class).
				add(Restrictions.eq("emailID", emailID))
				.add(Restrictions.eq("password",password)).uniqueResult();
		
	}

}
