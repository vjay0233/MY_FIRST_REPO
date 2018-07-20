package com.yepme.customer.bo;

import java.util.Date;

import java.sql.Blob;

public class ProductBO {

	private String Product_id;
	private String Product_Name;
	private String Super_id;
	private java.sql.Blob image_blob;
	private Date delivery_status;
	private int price;
	private int sub_total;
	private int quantity;
	
	
	public String getProduct_id() {
		return Product_id;
	}
	public void setProduct_id(String product_id) {
		Product_id = product_id;
	}
	public String getProduct_Name() {
		return Product_Name;
	}
	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}
	public String getSuper_id() {
		return Super_id;
	}
	public void setSuper_id(String super_id) {
		Super_id = super_id;
	}
	
	
	
	
	public Blob getImage_blob() {
		return image_blob;
	}
	public void setImage_blob(Blob image_blob) {
		this.image_blob = image_blob;
	}
	public Date getDelivery_status() {
		return delivery_status;
	}
	public void setDelivery_status(Date delivery_status) {
		this.delivery_status = delivery_status;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSub_total() {
		return sub_total;
	}
	public void setSub_total(int sub_total) {
		this.sub_total = sub_total;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductBO [Product_id=" + Product_id + ", Product_Name="
				+ Product_Name + ", Super_id=" + Super_id + ", image_blob="
				+ image_blob + ", delivery_status=" + delivery_status
				+ ", price=" + price + ", sub_total=" + sub_total
				+ ", quantity=" + quantity + "]";
	}
	
	
	
	
	
	
	
	
	
}
