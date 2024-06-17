package com.book.service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.message.ReusableMessage;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.book.entity.BookDetails;
import com.book.entity.OrderDetails;
import com.book.reposatory.BookReposatory;
import com.book.reposatory.OrderReposatory;
import com.book.request.BookByIdRequest;
import com.book.request.BookInfoRequest;
import com.book.request.OrderRequest;
import com.book.response.AllBooksResponse;
import com.book.response.BookByIdReponse;
import com.book.response.BookInfoResponse;
import com.book.response.OrderResponse;

@Service
public class BooksServiceImpl {

	@Autowired
	BookReposatory repo;
	
	@Autowired 
	OrderReposatory orderRepo;

	public String saveAllBooks(BookDetails book)
	{
		BookDetails res = repo.save(book);
		String result = "";
		if(res != null)
			result = "Saved";
		return result;
	}

	public List<BookByIdReponse>getBookById(BookByIdRequest request)
	{
		List<Object[]> bookList = repo.getBookById(request.getBookId());
		List<BookByIdReponse> books = bookList.stream()
				.map(data->{ 
					BookByIdReponse response = new BookByIdReponse();
					response.setBookName((String)data[0]); 
	                response.setAuthor((String)data[1]);
	                response.setSellerId((String)data[2]);
	                response.setPrice((String)data[3]);
	                response.setDecription((String)data[4]);
					return response;
				}).collect(Collectors.toList());
		return books;
	}
	public List<AllBooksResponse>getAllBooks()
	{
		 List<Object[]> allBookList = repo.getAllBooks();
		 List<AllBooksResponse> bookList = allBookList.stream()
		            .map(record -> {
		                AllBooksResponse response = new AllBooksResponse();
		                response.setBookId((String)record[0]);
		                response.setBookName((String) record[1]);
		                response.setPublishDate((String) record[2]);
		                response.setAuthorName((String) record[3]);
		                response.setPrice((Long) record[4]);
		                response.setDescription((String) record[5]);
		                byte[] imageData = Base64.getDecoder().decode((String)record[6]);
		                response.setImageEncode(imageData);
		                return response;
		            }).collect(Collectors.toList());
		        return bookList;
	}
	public List<BookInfoResponse> getBookInfo(BookInfoRequest request)
	{
		List<Object[]> bookList = repo.getBookInfo(request.getBookId());
		List<BookInfoResponse> books = bookList.stream()
				.map(book->{ 
					BookInfoResponse response = new BookInfoResponse();
					  response.setBookId((String)book[0]);
					  response.setBookName((String)book[1]);
					  response.setAuthorName((String)book[2]);
					  response.setPrice((Long)book[3]);
					  response.setBookDescription((String)book[4]);
					  response.setSellerName((String)book[5]);
					  response.setSellerEmail((String)book[6]);
					  response.setSellerPhone((String)book[7]);
					  response.setSellerAddress((String)book[8]);
					  response.setBookImage(Base64.getDecoder().decode((String)book[9]));
					  response.setSellerImage(Base64.getDecoder().decode((String)book[10]));
					 
					return response;
				}).collect(Collectors.toList());
		return books;
	}
	
	 public ResponseEntity<byte[]> getImage(String bookId) {
	        String imaginBase64 = repo.getBookImageById(bookId);
	        byte[] imageData = Base64.getDecoder().decode(imaginBase64);
	        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
	        headers.setContentType(MediaType.IMAGE_JPEG);
	        headers.setContentLength(imageData.length);
	        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
	    }
	 
	 public List<OrderResponse> fetchOrderDetails(OrderRequest request)
	 {
		 List<Object[]> orderList = repo.fetchOrderDetails(request.getBookId());
			List<OrderResponse> orders = orderList.stream()
					.map(order->{ 
						
						OrderResponse response = new OrderResponse();
						  response.setBookId((String)order[0]);
						  response.setBookName((String)order[1]);
						  response.setBookPrice((Long)order[2]);
						  response.setCustName((String)order[4]);
						  response.setCustPhone((String)order[5]);
						  response.setCustLandmark((String)order[6]);
						  response.setCustCity((String)order[7]);
						  response.setCustPincode((String)order[8]);
						  return response;
					}).collect(Collectors.toList());
		 return orders;
	 }
	 public String saveOrderDetails(OrderDetails order)
	 {
		 OrderDetails res = orderRepo.save(order);
		 String message ="Not Saved";
		 if(res!= null)
			 return message="Order Submitted";
		 return message;
	 }
}
