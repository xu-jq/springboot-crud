package com.xu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xu.domain.Book;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface BookService extends IService<Book> {

    IPage<Book> getPage(int currentPage, int pageSize);

    IPage<Book> getPage(int currentPage, int pageSize, Book book, HttpServletRequest request);

}
