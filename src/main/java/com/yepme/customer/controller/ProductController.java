package com.yepme.customer.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yepme.customer.bo.CategoryBO;
import com.yepme.customer.bo.CustomerBO;
import com.yepme.customer.bo.ProductBO;
import com.yepme.customer.service.CustomerServiceI;




@Controller
public class ProductController {
   
	@Autowired
	private CustomerServiceI service;
	
	
	@RequestMapping("/body")
	public ModelAndView giveWelcome(CategoryBO category,HttpSession session ){

//      Map<String, List<CategoryBO>> map=service.getProducts();
// 		
//	 //  System.out.println(map);
//		
//	   ServletContext context=session.getServletContext();
//	    
//		context.setAttribute("Category",map);
//		
//		//System.out.println("--------from context--------"+context.getAttribute("Category"));
//		
	   return new ModelAndView("body");

	}
	
	
	
				




		
	
	/**for getting  products
	 * 
	 * of a sub menu*/
	
	
	@RequestMapping("/customer")
	
	public ModelAndView getProduct(@RequestParam("ProductId") String ProductId,HttpSession session,HttpServletRequest request){
		
		
		
		System.out.println("Product is in controller----------"+ProductId);
		
		List<ProductBO> prdlist=service.getAllProduct(ProductId);
		
		System.out.println("from controller list"+prdlist);
		
		
		return new ModelAndView("Products","msg",prdlist);
	
	}
	
	
	@RequestMapping("/image")  
    public void subCatagoryimages(@RequestParam("id") String product_id,HttpServletRequest request,HttpServletResponse response) 
    		throws IOException, SQLException{
	
	 // System.out.println("image conversion controller 1");
      
	  Blob image=service.subCatagoryimages(product_id);
	  
	  ServletOutputStream out=response.getOutputStream();
	
	  java.io.InputStream io=image.getBinaryStream();
	
	  long length=image.length();
	
	//  System.out.println("image conversion controller 3");
	  
	  int bufferSize=1024;
	
	  byte[] buffer=new byte[bufferSize];
	
	  response.setContentType("image/jpg");
	
	  while ((length = io.read(buffer)) != -1) {
	       
		  out.write(buffer, 0, (int) length);
			  
		//  System.out.println("image conversion controller 2");

	      }
	
	  io.close();
	
	  out.flush();

	
	}
	
	@RequestMapping("singleProduct")
	
	public ModelAndView giveSingleProduct(@RequestParam("ProductId") String product_id){
		
	List<ProductBO> prd=service.getSingleProduct(product_id);
		
		
	
		return new ModelAndView("SingleProduct","msg",prd);
		
	}
		





 }