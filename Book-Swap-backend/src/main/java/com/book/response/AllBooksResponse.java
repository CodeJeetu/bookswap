package com.book.response;

import java.awt.image.DataBufferByte;

public class AllBooksResponse {

	private String bookId;
    private String bookName;
    private String publishDate;
    private String authorName;
    private long price;
    private String description;
    private byte[] imageEncode;
    
	public byte[] getImageEncode() {
		return imageEncode;
	}
	public void setImageEncode(byte[] imageEncode) {
		this.imageEncode = imageEncode;
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
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
    
	
}
