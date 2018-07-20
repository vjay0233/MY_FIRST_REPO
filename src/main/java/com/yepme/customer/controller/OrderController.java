package com.yepme.customer.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yepme.customer.bo.ProductBO;
import com.yepme.customer.service.CustomerServiceI;

@Controller
public class OrderController {

	
	
	 static Logger log=Logger.getLogger("OrderController");
	
	
	@Autowired
	private CustomerServiceI service;

//	Map<String, ProductBO> cart;

	//List addBagg;

	Set keys;

	/****
	 * adding products to cart
	 * 
	 * when customer
	 * 
	 * click on buy
	 * 
	 * **/
	@RequestMapping("cart")
	@ResponseBody
	public String CartPage(@RequestParam("id") String product_id,
			HttpSession session, HttpServletRequest request) {

	//	Map<String, ProductBO> cart;
		
	   int total=0;

		int quantity = 0;
        
		int Size =0;
	
       int subTotal = 0;

	Map<String,ProductBO> cart =(Map<String, ProductBO>)session.getAttribute("cartList");
		
		log.info("No Any Condition  ::::::: " + cart);
		
		List addBagg =(List)session.getAttribute("Bag");
		
		//total =(Integer)session.getAttribute("Total");
		
		//Size =(Integer)session.getAttribute("Size");
		
		//System.out.println("No Any Condition  ::::::: " + cart);

		if (cart == null && addBagg==null && total==0 && Size==0) {

	//	cart= (Map<String, ProductBO>)session.getAttribute("cartList");
			
			cart = new HashMap<String, ProductBO>();
			
			addBagg = new ArrayList();

			ProductBO product = service.Product(product_id);

			cart.put(product_id, product);
			
			System.out.println(cart);

			addBagg.add(product_id);

			session.setAttribute("Bag", addBagg);

			session.setAttribute("cartList", cart);

			total = total + product.getPrice();

			session.setAttribute("Total", total);

			/*
			 * quantity = quantity + product.getQuantity();
			 * 
			 * session.setAttribute("Quantity", quantity);
			 */

			log.info("bag size=======" + addBagg.size());
			
			//System.out.println("bag size=======" + addBagg.size());

			Size =addBagg.size();
            
			session.setAttribute("size",Size);
			
			return Integer.toString(Size);

		}

		else if (cart.containsKey(product_id)) {

			cart = (Map<String, ProductBO>) session.getAttribute("cartList");

			ProductBO product = service.Product(product_id);

			quantity = 1 + cart.get(product_id).getQuantity();

			product.setQuantity(quantity);

		//	cart.get(product_id).setQuantity(quantity);
			
			subTotal = quantity * product.getPrice();

			product.setSub_total(subTotal);

			//cart.get(product_id).setSub_total(subTotal);
			
			cart.put(product_id, product);

			addBagg = (List) session.getAttribute("Bag");

			addBagg.add(product_id);

			log.info("bag size in equal=======" + addBagg.size());
			
			//System.out.println("bag size in equal=======" + addBagg.size());

			total = product.getPrice()
					+ (Integer) session.getAttribute("Total");

			session.setAttribute("cartList", cart);

			session.setAttribute("Total", total);

			
            
			session.setAttribute("size",addBagg.size());
			
			return Integer.toString(addBagg.size());
		}

		else {

			cart = (Map<String, ProductBO>) session.getAttribute("cartList");

			ProductBO product = service.Product(product_id);

			cart.put(product_id, product);


			
			addBagg = (List) session.getAttribute("Bag");

			/*if(addBagg==null)
			{
				
			 List l=new ArrayList();
			 l.add(product_id);
			}*/
			addBagg.add(product_id);

			System.out.println("bag size not equal=======" + addBagg.size());

			session.setAttribute("cartList", cart);

			total = (Integer) session.getAttribute("Total")
					+ product.getPrice();

			session.setAttribute("Total", total);

			
            
			session.setAttribute("size",addBagg.size());
			
			return Integer.toString(addBagg.size());

		}

	}

	/* to return the cart page */

	@RequestMapping("addToCart")
	public ModelAndView giveCartPage() {

		return new ModelAndView("addToCart");

	}

	/**
	 * to update cart
	 * 
	 * from cart page
	 */

	@RequestMapping("upDateCart")
	@ResponseBody
	public String upDateCart(@RequestParam("id") String id,
			@RequestParam("quantity") int quantity, HttpSession session) {

		int total = 0;

		int subTotal = 0;
		
		
	List addBagg = addBag(session, quantity, id);  /*to change the bag size */
        
		session.setAttribute("size",addBagg.size());
		
		log.info("in main condition======="+addBagg.size());
		
		//System.out.println("in main condition======="+addBagg.size());
		
		session.setAttribute("Bag",addBagg);
		
		ProductBO product = service.Product(id);

		Map<String, ProductBO>	cart = (Map<String, ProductBO>) session.getAttribute("cartList");

		cart.get(id).setQuantity(quantity);

		subTotal = quantity * product.getPrice();

		cart.get(id).setSub_total(subTotal);

		for (Map.Entry<String, ProductBO> entry : cart.entrySet()) {

			// System.out.println("Key : " + entry.getKey() + " Value : " +
			// entry.getValue());

			total = total + entry.getValue().getQuantity()
					* entry.getValue().getPrice();

		}

		log.info("total is========" + total);
		
		//System.out.println("total is========" + total);
		
		log.info("subtotal is=============="+subTotal+"======"+cart.get(id).getSub_total());
		
		//System.out.println("subtotal is=============="+subTotal+"======"+cart.get(id).getSub_total());

		session.setAttribute("Total", total);

		session.setAttribute("cartList", cart);

		
		//System.out.println("bag size in update============" + addBagg.size());

		String update =addBagg.size()+"*"+total+"*"+subTotal;

		return update;

	}
	
	
	
	
	public List addBag(HttpSession session,int quantity,String id){
		
	Map<String,ProductBO> cart = (Map<String, ProductBO>)session.getAttribute("cartList");
	
	List addBagg = (List) session.getAttribute("Bag");

		log.info("bag size in update before update============"
				+ addBagg.size());
		
		//System.out.println("bag size in update before update============"+ addBagg.size());

		log.info("cart.get(id).getQuantity()====="+cart.get(id).getQuantity());
		
		
		//System.out.println("cart.get(id).getQuantity()====="+cart.get(id).getQuantity());
		
		log.info("quantity is========"+quantity);
		
		//System.out.println("quantity is========"+quantity);

		
		if (quantity > cart.get(id).getQuantity()) {
			
			
			for (int i = cart.get(id).getQuantity(); i < quantity; i++)

			{

				addBagg.add(id);

			}

			log.info("in if condition======="+addBagg.size());
			
			//System.out.println("in if condition======="+addBagg.size());

		} else {

			for (int i = cart.get(id).getQuantity(); i > quantity; i--) {

				addBagg.remove(id);
                 
				
			}

			log.info("in else======"+addBagg.size());
			 
			//System.out.println("in else======"+addBagg.size());

		}
		
		
		
		return addBagg;
	}
	
	
	
	
	
	
	
	
	

	/**
	 * To delete
	 * 
	 * products from
	 * 
	 * cart page
	 * */

	@RequestMapping("delete")
	@ResponseBody
	public String deleteCart(@RequestParam("id") String productId,
			HttpSession session) {
       
		
		int total = 0;
		
		Map<String, ProductBO>	cart = (Map<String, ProductBO>)session.getAttribute("cartList");
		
		List addBagg = (List) session.getAttribute("Bag");
		
		log.info("before remove cart size======="+cart.size());
		
		//System.out.println("before remove cart size======="+cart.size());
		cart.remove(productId);
		
		log.info("after remove cart size======="+cart.size());
		
		//System.out.println("after remove cart size======="+cart.size());
		
		for (Map.Entry<String, ProductBO> entry : cart.entrySet()) {

			// System.out.println("Key : " + entry.getKey() + " Value : " +
			// entry.getValue());

			total = total + entry.getValue().getQuantity()
					* entry.getValue().getPrice();

		}
		
		
		
					

		do {
			addBagg.remove(productId);

			session.setAttribute("Bag", addBagg);

		} while (addBagg.contains(productId));

		
		session.setAttribute("cartList", cart);
		
		session.setAttribute("Total", total);
		
		session.setAttribute("size", addBagg.size());
		
		String update = addBagg.size()+"*"+total+"*"+" ";
		
		return update;
		
	}

}
