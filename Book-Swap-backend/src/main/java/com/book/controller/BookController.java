package com.book.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.BookDetails;
import com.book.entity.OrderDetails;
import com.book.request.BookByIdRequest;
import com.book.request.BookInfoRequest;
import com.book.request.OrderRequest;
import com.book.request.SaveOrderRequest;
import com.book.response.AllBooksResponse;
import com.book.response.BookByIdReponse;
import com.book.response.BookInfoResponse;
import com.book.response.OrderResponse;
import com.book.service.BooksServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/Book-Swap")
public class BookController {
	
	@Autowired
	BooksServiceImpl sevice;
	
	@GetMapping("/test")
	public String test()
	{
		System.out.println("Inside Test ");
		return "BookController .... !";
	}
	@PostMapping("/save")
	public String saveBooks( @RequestBody BookDetails book)
	{
		return sevice.saveAllBooks(book);
	}
	@GetMapping("/getBook/{bookId}")
	public List<BookByIdReponse>getBookById(@PathVariable String bookId)
	{
		BookByIdRequest request= new BookByIdRequest();
		request.setBookId(bookId);
		List<BookByIdReponse> list = sevice.getBookById(request);
		return list;
	}
	@GetMapping("/allBooks")
	public List<AllBooksResponse> getAllBooks()
	{
		return sevice.getAllBooks();
	}
	@PostMapping("/getBook")
	public List<BookInfoResponse> getBookInfo(@RequestBody BookInfoRequest request)
	{
		List<BookInfoResponse> list = sevice.getBookInfo(request);
		return list;
		
	} 
	@GetMapping("/image/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) {
      return sevice.getImage(id);
     
    }

    @PostMapping("/order")
    public List<OrderResponse> fetchOrderDetails(@RequestBody OrderRequest request)
    {
    	List<OrderResponse> order = new ArrayList<>();
    	order = sevice.fetchOrderDetails(request);
    	return order;
    }
    
    public String saveOrder(@RequestBody OrderDetails request)
    {
    	String message = sevice.saveOrderDetails(request);
    	return null;
    }
}
