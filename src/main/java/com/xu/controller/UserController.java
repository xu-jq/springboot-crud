package com.xu.controller;


import com.xu.controller.utils.R;
import com.xu.domain.User;
import com.xu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public R save(@RequestBody User user){return new R(userService.save(user));}

    @GetMapping("{username}")
    public R check(@PathVariable String username){
        return new R(true,userService.check(username));
    }

    @PostMapping("/login")
    public R login(@RequestBody User user, HttpServletRequest request){
        if (userService.login(user) == true){
            HttpSession session = request.getSession();
            //往session中存入你想要的东西
            session.setAttribute("username", user.getUsername());
            String username = (String) request.getSession().getAttribute("username");
            System.out.println("username:"+username);
        }
        return new R(true,userService.login(user));
    }
}
