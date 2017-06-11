package com.jlson.struts2.helloword;

public class Product {

	private String productName;
	
	private Integer productId;
	
	private String productDes;
	
	private Double productPrice;
	
	public Product(){
		
	}

	public Product(String productName, Integer productId, String productDes, Double productPrice) {
		super();
		this.productName = productName;
		this.productId = productId;
		this.productDes = productDes;
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productId=" + productId + ", productDes=" + productDes
				+ ", productPrice=" + productPrice + "]";
	}
	
	
}
