package com.yepme.customer.bo;

public class CategoryBO {
	
	
	private String Category_Id;
    
	private String Category_Name;
	
	private String Super_id;

	public String getCategory_Id() {
		return Category_Id;
	}

	public void setCategory_Id(String category_Id) {
		Category_Id = category_Id;
	}

	public String getCategory_Name() {
		return Category_Name;
	}

	public void setCategory_Name(String category_Name) {
		Category_Name = category_Name;
	}

	public String getSuper_id() {
		return Super_id;
	}

	public void setSuper_id(String super_id) {
		Super_id = super_id;
	}

	@Override
	public String toString() {
		return "CategoryBO [Category_Id=" + Category_Id + ", Category_Name=" + Category_Name + ", Super_id=" + Super_id
				+ "]";
	}
	
	
	
}
