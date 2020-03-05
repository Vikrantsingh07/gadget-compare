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
	mv.addObject("greeting", "Welcome to spring web application");
		return mv;
	}
	
	
}
