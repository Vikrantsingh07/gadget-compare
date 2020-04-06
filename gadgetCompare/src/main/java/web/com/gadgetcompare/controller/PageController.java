package web.com.gadgetcompare.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import web.com.gadgetbackend.dao.CategoryDAO;
/**
 * @author Stalwart Vikrant
 *
 */
@Controller
public class PageController {

	PageController(){
		System.out.println("Controller layer is created ---------->");
	}
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value ={"/page"})
	public ModelAndView index(){
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title", "Home Page");
	mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value ={"/", "/home", "/index","/mainpage"})
	public ModelAndView mainpage(){
	ModelAndView mv=new ModelAndView("mainpage");
	mv.addObject("title", "Home Page");
	mv.addObject("userClickHome", true);
	//passing the list list of Category
	mv.addObject("categories",categoryDAO.list());
		return mv;
	}
	
	@RequestMapping(value ={"/about"})
	public ModelAndView about(){
	ModelAndView mv=new ModelAndView("mainpage");
	mv.addObject("title", "About Us");
	mv.addObject("userClickAbout", true);
		return mv;
	}
	
	@RequestMapping(value ={"/contact"})
	public ModelAndView contact(){
	ModelAndView mv=new ModelAndView("mainpage");
	mv.addObject("title", "Contact");
	mv.addObject("userClickContact", true);
		return mv;
	}
	
	@RequestMapping(value ={"/service"})
	public ModelAndView service(){
	ModelAndView mv=new ModelAndView("mainpage");
	mv.addObject("title", "Service");
	mv.addObject("userClickService", true);
		return mv;
	}
}
