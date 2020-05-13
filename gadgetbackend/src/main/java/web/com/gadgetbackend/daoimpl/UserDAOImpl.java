package web.com.gadgetbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import web.com.gadgetbackend.dao.UserDAO;
import web.com.gadgetbackend.dto.User;

public class UserDAOImpl implements UserDAO{
@Autowired
SessionFactory sessionfactory;

	public User getByEmail(String email) {
	  try{	
		return sessionfactory.getCurrentSession().get(User.class,email);
	  }
	  catch(Exception ex){
		  return null;
	  }
	}

	public User get(int id) {
	   try{	
		  return sessionfactory.getCurrentSession().get(User.class,Integer.valueOf(id));
	   }
	   catch(Exception ex){
		  return null;
	   }
	}

	public boolean add(User user) {
		  try{	
			  sessionfactory.getCurrentSession().persist(user);
			  return true;
		   }
		   catch(Exception ex){
			  return false;
		   }
	}
	

}
