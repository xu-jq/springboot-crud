package com.xu.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xu.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book>{
}
