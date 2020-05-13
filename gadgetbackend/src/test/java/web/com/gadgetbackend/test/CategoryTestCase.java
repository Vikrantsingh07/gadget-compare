package web.com.gadgetbackend.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.com.gadgetbackend.dao.CategoryDAO;
import web.com.gadgetbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	
	@BeforeClass
	public static void inti(){
		context=new AnnotationConfigApplicationContext();
		context.scan("web.com.gadgetbackend");
		context.refresh();
		
		categoryDAO =(CategoryDAO)context.getBean("categoryDAO");
	} 
	
	/**
	 * Insert Record  Test Case
	*/
	/*@Test
	public void testAddCategory(){
		category=new Category();
		//category.setId(101);
		 category.setName("Mobiles");
	     category.setDescription("This is moblie description");
	     category.setImageURL("M1.png");
	     category.setActive(true);
	     assertEquals("successfully added a category inside the table",true,categoryDAO.add(category));
	     
	}*/
	
	/**
	 * Get Record based on Id Test Case
	 */
	/*@Test
	public void testGetCategory(){
		category =categoryDAO.getid(1);
		assertEquals("successfully fetch a single category","Mobiles",category.getName());
	}*/
	
	/**
	 * Update Single Record Test Case
	 */
	/*@Test
	public void testUpdateCategory(){
		category =categoryDAO.getid(1);	
		category.setName("Television");
		assertEquals("successfully Update record in category",true,categoryDAO.update(category));
	}*/
	/**
	 * Delete Single Record Test Case
	 */
	@Test
	public void testDeleteCategory(){
		category =categoryDAO.getid(3);	
		assertEquals("successfully Delete record from category",true,categoryDAO.delete(category));
	}
	/**
	 * List of Category Test Case
	 */
	/*@Test
	public void testCategoryList(){
		//ArrayList<Category> lst =(ArrayList<Category>)categoryDAO.list();	
		assertEquals("successfully fetch the list of category",2,categoryDAO.list().size());
	}*/
	
	
	
}
