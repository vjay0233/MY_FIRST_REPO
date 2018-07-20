package com.yepme.customer.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.yepme.customer.bo.CustomerBO;



public class CustomerMapper  implements RowMapper<CustomerBO>{
	
	
	public CustomerBO mapRow(ResultSet rs, int rowno) throws SQLException {
		// TODO Auto-generated method stub
		CustomerBO customer=new CustomerBO();
		
		customer.setTitle(rs.getString(1));
        customer.setFirst_Name(rs.getString(2));
        customer.setLast_Name(rs.getString(3));
        customer.setEmail(rs.getString(4));
        customer.setPassword(rs.getString(5));
		
		return customer;
	}


}
