package web.com.gadgetbackend.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import web.com.gadgetbackend.dao.ProductDAO;
import web.com.gadgetbackend.dto.Product;

public class ProductTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private static Product product;
	
	@BeforeClass
	public static void inti(){
		context=new AnnotationConfigApplicationContext();
		context.scan("web.com.gadgetbackend");
		context.refresh();
		
		productDAO =(ProductDAO)context.getBean("productDAO");
	}
	@Test
	public void testGetProduct(){
		
	}

}
