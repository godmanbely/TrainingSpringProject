package com.miluo.bookman.controller;


import com.miluo.bookman.service.bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bookcontroller {

    @Autowired
    private bookservice bookService;
    /*
          根据书名进行模糊查询
          参数分别为bookname 书籍的名字
          输出为：全部包含的图书
   */
    @RequestMapping("getbookbybookname/{bookname}")
    public String GetUser(@PathVariable String bookname){
        return bookService.selectbybookname(bookname).toString();
    }

    /*
          根据作者名进行模糊查询
          参数分别为writername 作者的名字
          输出为：全部包含的图书
   */
    @RequestMapping("getbookbywritername/{writername}")
    public String GetBook(@PathVariable String writername){
        return bookService.selectByWriterName(writername).toString();
    }

}
