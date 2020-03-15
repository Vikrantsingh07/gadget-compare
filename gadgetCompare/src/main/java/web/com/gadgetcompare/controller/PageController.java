package web.com.gadgetcompare.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
/**
 * @author Stalwart Vikrant
 *
 */
@Controller
public class PageController {

	@RequestMapping(value ={"/", "/home", "/index"})
	public ModelAndView index(){
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title", "Home Page");
	mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value ={"/mainpage"})
	public ModelAndView mainpage(){
	ModelAndView mv=new ModelAndView("mainpage");
	mv.addObject("title", "Home Page");
	mv.addObject("userClickHome", true);
		return mv;
	}
	
	@RequestMapping(value ={"/about"})
	public ModelAndView about(){
	ModelAndView mv=new ModelAndView("page");
	mv.addObject("title", "About Us");
	mv.addObject("userClickAbout", true);
		return mv;
	}
}
