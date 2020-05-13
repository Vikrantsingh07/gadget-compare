package web.com.gadgetbackend.daoimpl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import web.com.gadgetbackend.dao.ProductDAO;
import web.com.gadgetbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	SessionFactory sessionfactory;

	/**
	 * Get Single Product based on Product Id
	 */
	public Product get(int productId) {
		try{
		    return sessionfactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
    
	/**
     * Get List of Active Product 
     */
	public List<Product> list() {
		return sessionfactory.getCurrentSession().createQuery("From Product",Product.class).getResultList();
	}

	/**
	 * Add New product
	 */
	public boolean add(Product product) {
	   try{
	        sessionfactory.getCurrentSession().persist(product);
	        return true;
	   }
	   catch(Exception ex){
		   ex.printStackTrace();
	   }
	   return false;
	}
    
	/**
     * Update Product 
     */
	public boolean update(Product product) {
	  try{
	      sessionfactory.getCurrentSession().update(product);
	      return true;
	  }
	  catch(Exception ex){
		  ex.printStackTrace();
	  }
	  return false; 
	}

	/**
	 * Delete product
	 */
	public boolean delete(Product product) {
		try{
		   product.setActive(false);
		   return this.update(product);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
	}

   /**
    * Get Product list by some parameters
    */
	public List<Product> getProductsByParam(String param, int count) {
		String selectProductList="From Product Where active=true ORDER BY "+param+" DESC";
		return sessionfactory.getCurrentSession().createQuery(selectProductList,Product.class).setFirstResult(0).setMaxResults(count).getResultList();
	}

	/**
	 *Get list only active products
	 */
	public List<Product> listActiveProducts() {
		String selectProductList="From Product Where active=:active";
		return sessionfactory.getCurrentSession().createQuery(selectProductList,Product.class).setParameter("active",true).getResultList();
	}
 
	/**
	 * Get list of Active Product by Category
	 */
	public List<Product> listActiveProductsByCategory(int categoryId) {
		return sessionfactory.getCurrentSession().createQuery("From Product Where active=:active AND categoryId=:categoryId",Product.class).setParameter("active",true).setParameter("categoryId",categoryId).getResultList();
	}

	/**
	 * Get list of Latest Active Product 
	 */
	public List<Product> getLatestActiveProducts(int count) {
		return sessionfactory.getCurrentSession().createQuery("FROM Product WHERE active = :active ORDER BY id",Product.class).setParameter("active",true).getResultList();
	}

}
