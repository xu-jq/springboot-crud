package com.xu.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xu.dao.BookDao;
import com.xu.domain.Book;
import com.xu.service.BookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
public class BookServiceImpl extends ServiceImpl<BookDao,Book> implements BookService {


    @Autowired
    private BookDao bookDao;


    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize, Book book, HttpServletRequest request) {
        String uid = (String) request.getSession().getAttribute("username");
        book.setUid(uid);

        QueryWrapper<Book> wrapper = new QueryWrapper<>();

        wrapper.eq("uid", book.getUid());
        wrapper.like("name",book.getName());
        wrapper.like("type",book.getType());
        wrapper.like("description",book.getDescription());
        IPage page = new Page(currentPage,pageSize);
        bookDao.selectPage(page,wrapper);
        return page;

    }
}
