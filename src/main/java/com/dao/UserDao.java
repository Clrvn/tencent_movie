package com.dao;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
	
	User login(@Param("username") String  username, @Param("username")String password);
	
	int addFriend(@Param("uId")Integer uId, @Param("friendUid") Integer friendUid);
	
	List<User> findAllFriend(@Param("uId")Integer uid);
	
	User getByPhone(@Param("phone")String phone);
	
}
