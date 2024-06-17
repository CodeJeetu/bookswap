package com.book.response;

public class BookInfoResponse {

	private String bookId;
    private String bookName;
    private String authorName;
    private long price;
    private String bookDescription;
    private String sellerName;
    private String sellerEmail;
    private String sellerPhone;
    private String sellerAddress;
    private byte[] bookImage;
    private byte[] sellerImage;
    
    
	public byte[] getBookImage() {
		return bookImage;
	}
	public void setBookImage(byte[] bookImage) {
		this.bookImage = bookImage;
	}
	public byte[] getSellerImage() {
		return sellerImage;
	}
	public void setSellerImage(byte[] sellerImage) {
		this.sellerImage = sellerImage;
	}
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
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getBookDescription() {
		return bookDescription;
	}
	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getSellerPhone() {
		return sellerPhone;
	}
	public void setSellerPhone(String sellerPhone) {
		this.sellerPhone = sellerPhone;
	}
	public String getSellerAddress() {
		return sellerAddress;
	}
	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}
}
