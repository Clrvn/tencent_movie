package com.service;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserService {
    
    @Autowired
    private UserDao dao;
    
    public User login(String username, String password) {
        return dao.login(username, password);
    }
    
    @Transactional(rollbackFor = Exception.class)
    public int addFriend(Integer uId, Integer friendUid) {
        return dao.addFriend(uId, friendUid);
    }
    
    public List<User> findAllFriend(Integer uid) {
        return dao.findAllFriend(uid);
    }
    
    public User getByPhone(String phone) {
        return dao.getByPhone(phone);
    }
    
}
