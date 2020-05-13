package web.com.gadgetbackend.dao;

import java.util.List;

import web.com.gadgetbackend.dto.Category;


public interface CategoryDAO {
	
	
	//Method 1
	List<Category> list();
	
	//Method 2
	Category getid(int id);

	//Method 3	
	boolean add(Category category);
	//Method 4
	boolean update(Category category);
	//Method 5
	boolean delete(Category category);
}
