package com.yepme.customer.dao;



import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.yepme.customer.bo.CategoryBO;
import com.yepme.customer.bo.CustomerBO;
import com.yepme.customer.bo.ProductBO;

public class CustomerDAOImpl implements CustomerDAOI {

	private JdbcTemplate jt;



	private static final String INSERT_INTO_Customer="insert into Customer(title,First_Name,Last_Name,Email,Password,Role)values(?,?,?,?,?,?)";

	private static final String FIND_Customer="select * from Customer where Email=? ";




	public CustomerDAOImpl(JdbcTemplate jt) {

		this.jt = jt;
	}




	public boolean authenticateCustomer(CustomerBO customer) {
		// TODO Auto-generated method stub

		boolean userExists = false;

		System.out.println("----------in authentication--------");

		
		System.out.println("customer name is======="+customer.getEmail()+customer.getPassword());
		
		
		List list=jt.queryForList("select * from Customer where Email=? and Password=?",customer.getEmail(),customer.getPassword());

		
		
		
        System.out.println("authentication is"+list);
		
        if(list.size()>0)

			return true;

		else

			return false;

	}




	public boolean insertCustomer(CustomerBO customer) {
		// TODO Auto-generated method stub


		System.out.println("-----------from dao oinsert--------------");
      
		List list=jt.queryForList("select * from Customer where Email=?",customer.getEmail());
		
		System.out.println(list);
		
		System.out.println("customer issss========"+customer.getTitle()+customer.getFirst_Name()+customer.getLast_Name());
		
		if(list.isEmpty()){
			
			int i=jt.update(INSERT_INTO_Customer,customer.getTitle(),customer.getFirst_Name(),customer.getLast_Name(),customer.getEmail(),customer.getPassword(),customer.getRole());
			
			return true;
	       	}
		
		else{
		
			
            return false;


} }



	public CustomerBO getCustomerDetails(String name) {
		// TODO Auto-generated method stub

		CustomerBO customer=jt.queryForObject(FIND_Customer, new CustomerMapper(),name);

		return customer;	

	}


   //For navigation bar main menu

	public Map<String, List<CategoryBO>> getTotalDetails() {
		// TODO Auto-generated method stub
		
		
		Map<String,List<CategoryBO>> map=new HashMap<String, List<CategoryBO>>();
		
		List<CategoryBO> category=getCategoryDetails();
		
		for (CategoryBO categoryBO : category) {
			
			System.out.println("category id is------"+categoryBO.getCategory_Id());
			
			List<CategoryBO> product=getProductDetails(categoryBO.getCategory_Id());
			
			//System.out.println("product is---------"+product);	
				
			map.put(categoryBO.getCategory_Name(),product);
				
			
		}
		
		return map;
	}


	//Method for getting category details  for main navigation bar
   
	public List<CategoryBO> getCategoryDetails(){
	   
	   String query="select * from Category1 where Super_Id=999";
	   
	return   jt.query(query, new RowMapper<CategoryBO>(){

		public CategoryBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			
			CategoryBO category=new CategoryBO();
			//System.out.println(category);
			category.setCategory_Id(rs.getString(1));
			category.setCategory_Name(rs.getString(2));
			category.setSuper_id(rs.getString(3));
			
			System.out.println(category);
			return category;
		}
		   
	   });
	
	}
	   
   
   
   //Method for getting product details
   
	public List<CategoryBO> getProductDetails(String categoryid){
		
		
		String sql="select * from Category1 where super_id='"
			    + categoryid + "'";
		
		return jt.query(sql,new RowMapper<CategoryBO>() {

			public CategoryBO mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				
				CategoryBO product=new CategoryBO();
				
				product.setCategory_Id(rs.getString(1));
				product.setCategory_Name(rs.getString(2));
				
				product.setSuper_id(rs.getString(3));
				return product;
			}
			
			
		});
		
	}
	
	
	/***Method to get
	 * 
	 * 
	 * all products
	 * */
	
	public List<ProductBO> getProduct(String categoryId){
		
		
		System.out.println("category id is in dao-------"+categoryId);
		
		String sql="select * from Product1 where Super_Id='" + categoryId + "'";
		
		List<ProductBO> prdlist=jt.query(sql,new RowMapper<ProductBO>(){

			public ProductBO mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				
				ProductBO product=new ProductBO();
				
				product.setProduct_id(rs.getString(1));
				
				product.setProduct_Name(rs.getString(2));
				
				product.setSuper_id(rs.getString(3));
				
				
				
				product.setPrice(rs.getInt(5));
				
				
				
				product.setQuantity(rs.getInt(8));
				
				
				
				return product;
			
			}});
		
		System.out.println("+product lis is--------"+prdlist.toString());
		
		return prdlist;
	    
		
	}
	
	
	/***Method to get
	 * 
	 * image
	 *
	 * */
	
	public Blob subCatagoryimages(String product_id){
	    String sql = "select image_blob from Product1 where Product_Id='"+ product_id+"'"; 
	  
	   System.out.println("-------------in image dao--------------");
	    
	Blob blob=    jt.queryForObject(sql,new RowMapper<Blob>(){

			public Blob mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				
				Blob so=(Blob)rs.getBlob(1);
				
			//	so.setImage_blob(rs.getBlob(1));
				
				return  so;
			}
	    	
	    	
	    	
	    	
	    });
	    
	    
	    return blob;
	    }	
	
	
	
	public List<ProductBO> getSingleProduct(String product_id) {
		// TODO Auto-generated method stub
		
		String sql="select * from Product1 where Product_Id='"+product_id+"'";
		
		List<ProductBO> product=jt.query(sql,new RowMapper<ProductBO>(){

			public ProductBO mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				
				ProductBO prd=new ProductBO();
				
				prd.setProduct_id(rs.getString(1));
				
				prd.setProduct_Name(rs.getString(2));
				
				prd.setImage_blob((Blob)rs.getBlob(4));
				
				prd.setPrice(rs.getInt(5));
				
				//prd.setDelivery_status(rs.getDate(6));
				
				prd.setSub_total(rs.getInt(7));
				
				prd.setQuantity(rs.getInt(8));
				
				prd.setSuper_id(rs.getString(3));
				
				return prd;
			}});
		
		return product;
	}
	
	
	
	
	public ProductBO SingleProduct(String product_id){
		
		String sql="select * from Product1 where Product_Id='"+product_id+"'";
		
		ProductBO product = jt.queryForObject(sql, new RowMapper<ProductBO>(){

			public ProductBO mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				// TODO Auto-generated method stub
				
				ProductBO prd=new ProductBO();
				
prd.setProduct_id(rs.getString(1));
				
				prd.setProduct_Name(rs.getString(2));
				
				prd.setImage_blob(rs.getBlob(4));
				
				prd.setPrice(rs.getInt(5));
				
				//prd.setDelivery_status(rs.getDate(6));
				
				prd.setSub_total(rs.getInt(7));
				
				prd.setQuantity(rs.getInt(8));
				
				prd.setSuper_id(rs.getString(3));
				
				return prd;
				
			}});
		
		return product;
	}
	
   
   }


