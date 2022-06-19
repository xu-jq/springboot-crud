package com.xu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xu.controller.utils.R;
import com.xu.domain.Book;
import com.xu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping()
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book, HttpServletRequest request) throws IOException {
        String username = (String) request.getSession().getAttribute("username");
        book.setUid(username);
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){return new R(bookService.removeById(id));}

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){return new R(true,bookService.getById(id));}

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book,HttpServletRequest request){
        IPage<Book> page = bookService.getPage(currentPage,pageSize,book,request);
        if (currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize,book,request);
        }
        if (book.getUid()==null){
            System.out.println("session为null!!!!!");
            return new R(true,"请先登录");
        }
        return new R(true,page);}
}
