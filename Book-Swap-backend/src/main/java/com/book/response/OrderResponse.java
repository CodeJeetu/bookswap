package com.book.response;

public class OrderResponse {
	
	private String bookId;
	private String bookName;
	private long bookPrice;
	private String bookAuthor;
	private String custName;
	private String custPhone;
	private String custLandmark;
	private String custCity;
	private String custPincode;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public long getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(Long bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustPhone() {
		return custPhone;
	}
	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}
	public String getCustLandmark() {
		return custLandmark;
	}
	public void setCustLandmark(String custLandmark) {
		this.custLandmark = custLandmark;
	}
	public String getCustCity() {
		return custCity;
	}
	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}
	public String getCustPincode() {
		return custPincode;
	}
	public void setCustPincode(String custPincode) {
		this.custPincode = custPincode;
	}

}
