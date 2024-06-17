package com.book.reposatory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.book.entity.BookDetails;
import com.book.response.AllBooksResponse;
import com.book.response.BookByIdReponse;

public interface BookReposatory extends JpaRepository<BookDetails, Integer>{

	@Query(value  = "SELECT BOOK_NAME,AUTHOR_ID,SELLER_ID,PRICE,DESCRIPTION FROM SW_BOOK_DTL WHERE BOOK_ID= :bookId ",nativeQuery = true)
	List<Object[]> getBookById(String bookId);
	
	@Query(value  = "SELECT BOOK_ID, BOOK_NAME,Publish_date,AUTHOR_NAME,PRICE,short_desc,IMAGE_1 FROM SW_BOOK_DTL WHERE REC_STATUS = 'A' ",nativeQuery = true)
	List<Object[]> getAllBooks();
	
	@Query(value = "SELECT BOOK_ID, BOOK_NAME,AUTHOR_NAME,PRICE,DESCRIPTION,SEL.NAME,SEL.EMAIL,SEL.PHONE,CONCAT(IFNULL(SEL.ADDRESS1,SEL.ADDRESS2),' ',SEL.PINCODE) AS ADDRESS ,SW_BOOK_DTL.IMAGE_1,SEL.IMAGE_1 "
			+ "FROM sw_book_dtl JOIN sb_seller_dtl sel ON sw_book_dtl.seller_id = sel.user_id WHERE sw_book_dtl.Rec_status = 'A' AND BOOK_ID =:bookId",nativeQuery = true)
	List<Object[]> getBookInfo(String bookId);
	
	@Query(value = "SELECT IMAGE_1 FROM SW_BOOK_DTL where BOOK_ID=:boookId",nativeQuery =  true)
	 public String getBookImageById(String boookId);
	
	@Query(value = "SELECT B.BOOK_ID,B.BOOK_NAME,B.PRICE,B.AUTHOR_NAME,U.FULL_NAME,U.PHONE_NUMBER,U.LANDMARK,U.CITY,U.PINCODE FROM SW_BOOK_DTL B JOIN SB_SELLER_DTL S ON  B.SELLER_ID = S.USER_ID JOIN SWAP_USER_M U ON U.ID = S.SELLER_ID WHERE B.BOOK_ID =:bookId",nativeQuery = true)
	public List<Object[]>fetchOrderDetails(String bookId);

}
