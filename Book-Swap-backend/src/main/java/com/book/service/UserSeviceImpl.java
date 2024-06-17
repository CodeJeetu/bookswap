package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.book.reposatory.UserReposatory;
import com.book.user.entity.SaveUserData;
import com.book.user.entity.UserCredetial;
import com.book.utility.CommonFunction;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class UserSeviceImpl {
	
	@Autowired
	UserReposatory reposatory;

	public SaveUserData SaveUserData(SaveUserData user)
	{
		user.setFullName(CommonFunction.generateFullName(user));
		user.setUserName(CommonFunction.generateUserName(user.getFullName(), user.getDateOfBirth()));
		String password = CommonFunction.generatePassword(user.getUserName(), user.getDateOfBirth());
		SaveUserData status = reposatory.save(user);
		boolean passUpdate = false;
		if(status != null)
		{
			 int rowsAffected= reposatory.updatePassword(password,status.getUserName());
			 if (rowsAffected > 0) {
			        // Password updated successfully
			    } else {
			        // Password update failed
			    }
		}
		return status;
	}
	public String userLogin(UserCredetial credntial)
	{
		String storeduserPass = reposatory.getUserPass(credntial.getUserId());
		String password = credntial.getUserPassword();
		if(credntial.getUserId().equals(reposatory.getUserName(credntial.getUserId())))
		{	
			if(storeduserPass.equals(password))
			{
				return "SuccesFully Login";
			}
			return "Password is Incorrect";
		}else {
			return"UserId is incorrect";
		}
	}
}
