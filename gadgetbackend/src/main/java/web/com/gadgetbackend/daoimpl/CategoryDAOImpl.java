package web.com.gadgetbackend.daoimpl;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.com.gadgetbackend.dao.CategoryDAO;
import web.com.gadgetbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
	private SessionFactory sessionFactory; 

	
	
	public List<Category> list() {
		System.out.println("Calling Category List----->");
		String selectCategoryQuery="From Category where active =:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectCategoryQuery);
		query.setParameter("active", true);
		List<Category> data =query.getResultList();
		System.out.println("query result----->"+data);
		return data;
	}

	/**
	 * Get Single Category record based on id
	 */
	public Category getid(int id) {
		 System.out.println("Calling Getid method----->");
		 System.out.println("Getid----->"+id);
		 return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	
	}
    /**
     * Add record in Category
    */
	public boolean add(Category category) {
	  try{
	  	  System.out.println("Calling Add method----->");
	   	  System.out.println("category----->"+category.getName());
	 	  //add the category to the Database table
	 	  try{
  		      sessionFactory.getCurrentSession().persist(category);
		      System.out.println("Category Reocrd persist getCurrentSession for Add method----->");
		  }
		  catch(HibernateException e){
			  sessionFactory.openSession().persist(category);	
			  System.out.println("Category Reocrd persist openSession for Add method----->");
		  }  
		  return true;
	  }
	  catch(Exception ex){
		   ex.printStackTrace();
		   return false;
	  }
   }
   /**
    * Update record in Category
    */
	public boolean update(Category category) {
	  try{
		  System.out.println("Calling Update method----->");
		  System.out.println("category----->"+category.getName());
		  //Update record in category to the Database table
		  try{
	  		   sessionFactory.getCurrentSession().update(category);
			   System.out.println("Category Record Update getCurrentSession for update method----->");
		  }
		  catch(HibernateException e){
			   sessionFactory.openSession().update(category);	
			   System.out.println("Category Record Update by openSession for update method----->");
			 }  
			  return true;
		}
		catch(Exception ex){
			ex.printStackTrace();
			return false;
		}
	}

	 /**
	  * Delete record in Category
	  */
	public boolean delete(Category category) {
		 System.out.println("Calling Delete method----->");
		 sessionFactory.getCurrentSession().delete(category);
		 System.out.println("Category Record Delete getCurrentSession for update method----->");
		return true;
	}
}
