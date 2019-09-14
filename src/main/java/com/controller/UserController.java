package com.controller;

import com.entity.User;
import com.enums.ResultFailureEnum;
import com.service.UserService;
import com.util.JsonResultVOUtil;
import com.vo.JsonResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService service;
    
    @PostMapping(value = "login")
    public JsonResultVO login(String username,
                              String password, HttpSession session) {
        User user = service.login(username, password);
        
        if (user != null) {
            session.setAttribute("user", user);
            return JsonResultVOUtil.success(user);
        } else {
            return JsonResultVOUtil.failure(ResultFailureEnum.LOGIN_ERROR);
        }
    }
    
    @PostMapping(value = "/addFriend")
    public JsonResultVO addFriend(Integer friendUid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            return JsonResultVOUtil.failure(ResultFailureEnum.NOT_LOGIN);
        }
        try {
            service.addFriend(user.getUid(), friendUid);
            return JsonResultVOUtil.success();
        } catch (Exception ex) {
            return JsonResultVOUtil.failure(ResultFailureEnum.ADD_Friend_Failure);
        }
        
    }
    
    @GetMapping(value = "/findAllFriend")
    public JsonResultVO findAllFriend(HttpSession session) {
        
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            return JsonResultVOUtil.failure(ResultFailureEnum.NOT_LOGIN);
        }
        return JsonResultVOUtil.success(service.findAllFriend(user.getUid()));
    }
    
    @GetMapping(value = "/getByPhone")
    public JsonResultVO getByPhone(String phone, HttpSession session) {
        User user = (User) session.getAttribute("user");
        
        if (user == null) {
            return JsonResultVOUtil.failure(ResultFailureEnum.NOT_LOGIN);
        }
        return JsonResultVOUtil.success(service.getByPhone(phone));
    }
    
}
