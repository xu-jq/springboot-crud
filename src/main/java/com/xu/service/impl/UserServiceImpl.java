package com.xu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xu.dao.UserDao;
import com.xu.domain.User;
import com.xu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Boolean check(String username) {

        HashMap<String,Object> map = new HashMap();
        map.put("username",username);
        List<User> list = userDao.selectByMap(map);
        Boolean b;
        if (list.isEmpty()){
            b=true;
        }else {
            b=false;
        }

        return b;
    }

    @Override
    public Boolean login(User user) {
        HashMap<String,Object> map = new HashMap();
        map.put("username",user.getUsername());
        map.put("password",user.getPassword());
        List<User> list = userDao.selectByMap(map);
        Boolean a;
        if (list.isEmpty()){
            a = false;
        }else {
            a = true;
        }
        return a;
    }
}
