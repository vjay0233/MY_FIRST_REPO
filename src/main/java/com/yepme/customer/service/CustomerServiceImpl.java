package com.yepme.customer.service;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import com.yepme.customer.bo.CategoryBO;
import com.yepme.customer.bo.CustomerBO;
import com.yepme.customer.bo.ProductBO;
import com.yepme.customer.dao.CustomerDAOI;


public class CustomerServiceImpl implements CustomerServiceI{
	
	private	CustomerDAOI dao;
	

	public CustomerServiceImpl(CustomerDAOI dao) {
	
		
		this.dao = dao;
	
	}

	public boolean authenticateCustomer(CustomerBO customer) {
		// TODO Auto-generated method stub
		
		System.out.println("----------in authentication--------");
		
		boolean userExist=false;
		
        userExist=dao.authenticateCustomer(customer);
	 
        if(userExist)
    	 
    	  return true;
        
        else
    	 
    	  return false;
	
	}

	
	
	public boolean saveCustomer(CustomerBO customer) {
		// TODO Auto-generated method stub
		
		System.out.println("-----from service of insert");
		
		boolean status=false;
		
		status=dao.insertCustomer(customer);
		
		if(status)
		
			return true;
		
		else
		
			return false;
	}

	public CustomerBO findCustomerDetais(String name) {
		// TODO Auto-generated method stub
		CustomerBO cust=dao.getCustomerDetails(name);
		
		return cust;
	
	}

/*	public List<CategoryBO> getCategory(CategoryBO category) {
		// TODO Auto-generated method stub
		
	List list=dao.getCategoryDetails(category);
		System.out.println(list);
		return list;
	}*/

	public Map<String, List<CategoryBO>> getProducts() {
		// TODO Auto-generated method stub
		
		Map<String, List<CategoryBO>> map=dao.getTotalDetails();
		
		return map;
	}

	public List<ProductBO> getAllProduct(String categoryId) {
		// TODO Auto-generated method stub
		
		List<ProductBO> prdlist=dao.getProduct(categoryId);
		
		return prdlist;
	}
	
	
	public Blob subCatagoryimages(String product_id) {
		// TODO Auto-generated method stub
		
		Blob blob=dao.subCatagoryimages(product_id);
		return blob;
	}
	
	public List<ProductBO> getSingleProduct(String product_id){
		
	List<ProductBO> product=dao.getSingleProduct(product_id);
		
		return product;
		
		
	}
	
	public ProductBO Product(String product_id){
		
		
		ProductBO product = dao.SingleProduct(product_id);
		
		
		return product;
		
	}
	

}
