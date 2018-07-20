package com.yepme.customer.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.yepme.customer.bo.CustomerBO;
import com.yepme.customer.service.CustomerServiceI;

@Controller
public class LoginController {

	
	
	@Autowired
	private CustomerServiceI service;
	
	
	
	
//	HttpSession session;
	
	   
		 @RequestMapping(value="/index", method = RequestMethod.GET)  
		 public String executeSecurity(ModelMap model, Principal principal,HttpServletRequest request) {  
		   
		  String name = principal.getName();  
		  model.addAttribute("Customer", name);  
		  model.addAttribute("message", "Welcome To Yepme");  
		  
		 HttpSession session=request.getSession();
	      System.out.println("name is===="+name);
		
	     CustomerBO cust=service.findCustomerDetais(name);
	      
	      System.out.println("in session-----"+cust.getFirst_Name());
	      
	      session.setAttribute("Customer1",cust);
			
	      System.out.println("session is========="+session.getAttribute("Customer1"));
			
			 System.out.println("session is========="+session.getAttribute("cartList"));
			 
			 System.out.println("session is========="+session.getAttribute("Total"));
			 System.out.println("session is========="+session.getAttribute("Bag"));
			 
			 System.out.println("session is========="+session.getAttribute("size"));
			
	      
		  
		  return "success";  
		   
		 }  
		   
		 @RequestMapping(value="/login", method = RequestMethod.GET)  
		 public String login(ModelMap model) {  
		   
		 		 
			 return "Login";
			 
		 }  
		   
		 @RequestMapping(value="/fail2login", method = RequestMethod.GET)  
		 public String loginerror(ModelMap model) {  
		   
		  model.addAttribute("error", "true");  
		  return "Login";  
		   
		 }  
		   
		 @RequestMapping(value="/logout", method = RequestMethod.GET)  
		 public String logout(ModelMap model,HttpSession session) {  
		   
			/* session.removeAttribute("Customer1");
			session.removeAttribute("cartList"); 
			session.removeAttribute("Total");
			session.removeAttribute("size"); 
			*/
			 
			 
			 System.out.println("session is========="+session.getAttribute("Customer1"));
			
			 System.out.println("session is========="+session.getAttribute("cartList"));
			 
			 System.out.println("session is========="+session.getAttribute("Total"));
			 System.out.println("session is========="+session.getAttribute("Bag"));
			 
			 System.out.println("session is========="+session.getAttribute("size"));
			 session.invalidate();
			 
			 
		//	 session.removeAttribute("Bag");
			
		  return "Login";  
		   
		 }
	
	
	
	
	/*//to get login page
	@RequestMapping("/log")
	public ModelAndView giveLoginPage(HttpServletRequest request,HttpServletResponse response){


			return new ModelAndView("Login","msg","login here");

	}





to authenticate customer

	@RequestMapping("/login")
		public ModelAndView handlerRequest(@ModelAttribute CustomerBO customer,HttpServletRequest request){
		
		    System.out.println("----------in Model and view--------");
		
		    boolean	userExist=false;
			
		    userExist=service.authenticateCustomer(customer);
		    
		    if(userExist)
		    {
				
	        HttpSession session=request.getSession();
	        
	        CustomerBO cust=service.findCustomerDetais(customer);
            
	        System.out.println("in session-----"+cust.getFirst_Name());
	        
	        session.setAttribute("Customer",cust);
			
	        System.out.println("in model and view"+cust.getFirst_Name());
		    
	  		return new ModelAndView("success","msg1","hello"+cust.getFirst_Name());
		     
		     }
		
	  
		    else
		
		    {
	
		  return new ModelAndView("Error","msg","incorrect name or password");
		
		    }	
	
	}


 /*to give profile page*/

	 @RequestMapping("/profile")
	 public ModelAndView giveProfile(HttpServletRequest request,HttpServletResponse response){
		
     return new ModelAndView("Profile","msg","your profile is");
     }
	
	  //to logout
	
	/*@RequestMapping("/logout")
	public ModelAndView Logout(){
		
	return new ModelAndView("Logout","msg","you are successfully logged out");
		
	 }
*/	
	      
	
	/*to give register page*/
	
	 @RequestMapping("/reg")
	 public ModelAndView giveRegisterPage(HttpServletRequest request,HttpServletResponse response){

     return new ModelAndView("Register","msg",new CustomerBO());

	 }
	
		
	     /**Method
	      * 
	      * 
	      * *to save customer details*/
	
	
	@RequestMapping("/register")
	public ModelAndView RegisterHandler(@ModelAttribute CustomerBO customer,HttpServletRequest request){
	
	boolean status=false;
		
		System.out.println("----------in Model and view of register--------");
	
		
		System.out.println("in model and view customer name is===="+customer.getFirst_Name());
	
    status=service.saveCustomer(customer);
   
    System.out.println(status);
    
    if(status)
   
    	return new ModelAndView("Enter","msg","hello    "+customer.getFirst_Name()+"   login now");
    
    else
    	
    	
    	return new  ModelAndView("failed","msg","email already exist");
    
	}

	@RequestMapping("/placeOrder")
	public String PlaceOrder(HttpSession session){
		
		CustomerBO customer = (CustomerBO) session.getAttribute("Customer1");
		
		if(customer==null){
			
			
			
			return "Login";
			
		}
		
		else{
			
			
			return "Adress";
			
		}
		
		
		
	}
	
	
	
}
