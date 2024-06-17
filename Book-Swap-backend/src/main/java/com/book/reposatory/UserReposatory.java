package com.book.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.book.user.entity.SaveUserData;

@Repository
public interface UserReposatory extends JpaRepository<SaveUserData, Integer>{
	
	@Modifying
	@Query(value = "UPDATE SWAP_USER_M SET USER_PASSWORD = ENCRYPT_PASSWORD(:userPass) WHERE USER_NAME=:userName  AND REC_STATUS ='A'",nativeQuery = true)
	public int  updatePassword(String userPass, String userName);
	
	@Query(value = "SELECT USER_NAME FROM SWAP_USER_M where 1=1 and USER_NAME=:userName",nativeQuery = true)
	public String getUserName(String userName);
	
	@Query(value = "SELECT DECRYPT_PASSWORD(USER_PASSWORD) FROM SWAP_USER_M WHERE  USER_NAME= :userName",nativeQuery = true)
	public String getUserPass(String userName);
	

}
