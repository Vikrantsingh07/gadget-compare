package web.com.gadgetcompare.controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.com.gadgetbackend.dao.CategoryDAO;
import web.com.gadgetbackend.dao.ProductDAO;
import web.com.gadgetbackend.dto.Category;
import web.com.gadgetbackend.dto.Product;
import web.com.gadgetcompare.exception.ProductNotFoundException;
/**
 * @author Stalwart Vikrant
 *
 */
@Controller
public class PageController {
private static final Logger logger= LoggerFactory.getLogger(PageController.class); 
	PageController(){
	  System.out.println("Controller layer is created ---------->");
	}
	
	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	
	
	
/**
 * 	
 * Request Mapping for Home Page 
 */
	@RequestMapping(value ={"/", "/home", "/index","/mainpage"})
	public ModelAndView mainpage(){
	  ModelAndView mv=new ModelAndView("mainpage");
	  mv.addObject("title", "Home Page");
	  mv.addObject("userClickHome", true);
	  //passing the list list of Category
	  mv.addObject("categories",categoryDAO.list());
	  logger.info("Inside this page controller----->");
	  return mv;
	}
	
/**	
 * Request Mapping for About
 */
	@RequestMapping(value ={"/about"})
	public ModelAndView about(){
	  ModelAndView mv=new ModelAndView("mainpage");
	  mv.addObject("title", "About Us");
	  mv.addObject("userClickAbout", true);
	  return mv;
	}
	
/**	
 * Request Mapping for Contact
 */
	@RequestMapping(value ={"/contact"})
	public ModelAndView contact(){
	  ModelAndView mv=new ModelAndView("mainpage");
	  mv.addObject("title", "Contact");
	  mv.addObject("userClickContact", true);
	  return mv;
	}
	
/**	
 * Request Mapping for show All Product
 */
	@RequestMapping(value ={"/show/all/products"})
	public ModelAndView showAllProduct(){
	  ModelAndView mv=new ModelAndView("mainpage");
	  mv.addObject("title", "All Products");
	  mv.addObject("userClickAllProduct", true);
	  mv.addObject("categories",categoryDAO.list());
	  return mv;
    }
	
/**
 * 	Request Mapping for show Category Product
 */
	
   @RequestMapping(value ={"/show/category/{id}/products"})
   public ModelAndView service(@PathVariable("id") int id) {
	  System.out.println("category Product Id ---------->"+id); 
	  ModelAndView mv=new ModelAndView("mainpage");
	  Category category=categoryDAO.getid(id);
	  System.out.println("category.getName ---------->"+category.getName());
	  mv.addObject("title", category.getName());
	  mv.addObject("userclickCategoryProduct", true);
	  mv.addObject("category",category);
	  return mv;
   }
   
   /**
    * 	Viewing Single Product
    */
   
   @RequestMapping(value={"/show/{id}/product"}) 
    public ModelAndView showsingleProduct(@PathVariable int id)throws ProductNotFoundException{
	  ModelAndView mv=new ModelAndView("mainpage");
	  Product product=productDAO.get(id);
	  if(product==null) throw new ProductNotFoundException();
	  System.out.println("product.getViews ---------->"+product.getViews());
	  product.setViews(product.getViews()+1); 
	  //Update view count
	  productDAO.update(product);
	  mv.addObject("title",product.getName());
	  mv.addObject("product", product);
	  mv.addObject("userClickShowProduct",true);
	   return mv; 
   }  
   
}
