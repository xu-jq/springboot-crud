package com.xu.controller.utils;

import com.xu.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class R {
    private Boolean flag;
    private Object data;
    private String msg;

    public R(){}

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }

    public R(String msg){
        this.flag = false;
        this.msg = msg;
    }

}
