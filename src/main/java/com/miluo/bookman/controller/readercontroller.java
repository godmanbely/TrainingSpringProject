package com.miluo.bookman.controller;



import com.miluo.bookman.mapper.BookAndNameMapper;
import com.miluo.bookman.service.bookandreaderservice;
import com.miluo.bookman.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class readercontroller {

    @Autowired
    bookandreaderservice bookandreaderservice;
    /*
        读者借书请求
        参数分别为reader_id:读者ID和book_id:书籍ID
        输出为：能否借书成功
     */
    @RequestMapping("borrowbook/{reader_id}/{book_id}")
    public Result GetBook(@PathVariable("reader_id") Integer reader_id, @PathVariable("book_id") Integer book_id){
             return bookandreaderservice.insert(reader_id,book_id);
    }

    /*
           读者还书请求
           参数分别为reader_id:读者ID和book_id:书籍ID
           输出为：还书是否成功
    */
    @RequestMapping("releasebook/{reader_id}/{book_id}")
    public Result ReleaseBook(@PathVariable("reader_id") Integer reader_id, @PathVariable("book_id") Integer book_id){
               return bookandreaderservice.delete(reader_id,book_id);
    }
    /*
           读者所借用图书的详情显示，包括结束时间
           参数分别为reader_id:读者ID
           输出为：所有被借的书
    */
    @RequestMapping("showbook/{reader_id}")
    public String ReleaseBook(@PathVariable("reader_id") Integer reader_id){
        return bookandreaderservice.showbook(reader_id).toString();
    }

}
