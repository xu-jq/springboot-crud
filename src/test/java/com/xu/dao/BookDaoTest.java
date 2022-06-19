package com.xu.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xu.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){

        System.out.println(bookDao.selectList(null));
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("4");
        book.setType("4");
        book.setDescription("4");
        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(5);
        book.setName("5");
        book.setType("5");
        book.setDescription("5");
        bookDao.updateById(book);
    }

    @Test
    void testDelete(){
        bookDao.deleteById(5);
    }

    @Test
    void testGetAll(){
        List<Book> bookList = bookDao.selectList(null);
        for (Book book : bookList) {
            System.out.println(book);
        }
    }

    @Test
    void testGetPage(){
        IPage page = new Page(2,3);
        bookDao.selectPage(page,null);
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name","2");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Book::getName,"2");
        bookDao.selectList(lqw);
    }
}
