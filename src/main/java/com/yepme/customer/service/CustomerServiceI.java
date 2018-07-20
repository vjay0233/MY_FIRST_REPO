package com.yepme.customer.service;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import com.yepme.customer.bo.CategoryBO;
import com.yepme.customer.bo.CustomerBO;
import com.yepme.customer.bo.ProductBO;



public interface CustomerServiceI {
	
	
	public  boolean authenticateCustomer(CustomerBO customer);

	 public boolean saveCustomer(CustomerBO customer);

	public CustomerBO findCustomerDetais(String name);

//	public List<CategoryBO> getCategory(CategoryBO category);

	public Map<String, List<CategoryBO>> getProducts();
	
	public List<ProductBO> getAllProduct(String categoryId);
	
	public Blob subCatagoryimages(String ProductId);
	
	public List<ProductBO> getSingleProduct(String product_id);
	
	public ProductBO Product(String product_id);
}
