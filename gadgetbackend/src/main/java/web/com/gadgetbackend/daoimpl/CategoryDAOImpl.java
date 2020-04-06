package web.com.gadgetbackend.daoimpl;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import web.com.gadgetbackend.dao.CategoryDAO;
import web.com.gadgetbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	private static List<Category> categories= new ArrayList<Category>(); 
	
	static{
	     System.out.println("static Method call----->");
		//1st Category
	     Category category=new Category();
	     category.setId(1);
	     category.setName("Mobiles");
	     category.setDescription("This is moblie description");
	     category.setImageURL("M1.png");
	     categories.add(category);
		 //2nd Category
	     category=new Category();
	     category.setId(2);
	     category.setName("Tablets");
	     category.setDescription("This is Tablets description");
	     category.setImageURL("TAB1.png");
	     categories.add(category);
		 //3rd Category
	     category=new Category();
	     category.setId(3);
	     category.setName("Laptops");
	     category.setDescription("This is Laptop description");
	     category.setImageURL("Lap.png");
	     categories.add(category);

	}
	
	public List<Category> list() {
			return categories;
	}
}
