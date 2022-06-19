package com.xu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.domain.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends IService<User> {
    Boolean check(String username);

    Boolean login(User user);
}
