package com.yepme.customer.dao;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

import com.yepme.customer.bo.CategoryBO;
import com.yepme.customer.bo.CustomerBO;
import com.yepme.customer.bo.ProductBO;

public interface CustomerDAOI {
	public  boolean authenticateCustomer(CustomerBO customer);
	public boolean insertCustomer(CustomerBO customer);
	
	public CustomerBO getCustomerDetails(String name);
	
 //   public List<CategoryBO> getCategoryDetails(CategoryBO category);
	
    public Map<String, List<CategoryBO>> getTotalDetails();

    public List<ProductBO> getProduct(String categoryId);
    
    public java.sql.Blob subCatagoryimages(String product_id);
    
    public List<ProductBO> getSingleProduct(String product_id);

    
    public ProductBO SingleProduct(String product_id);
}