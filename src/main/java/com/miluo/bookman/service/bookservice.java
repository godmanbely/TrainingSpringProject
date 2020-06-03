package com.miluo.bookman.service;


import com.miluo.bookman.entity.Book;
import com.miluo.bookman.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class bookservice {
    @Autowired
    BookMapper bookmappers;
    public Book selectbybookname(String bookname){
        return  bookmappers.selectByBookName(bookname);
    }

    public List<Book> selectByWriterName(String writerName){
        return bookmappers.selectByWriterName(writerName);
    }

    public Book selectByPrimaryKey(Integer book_id){
        return bookmappers.selectByPrimaryKey(book_id);
    }
    public int updateByPrimaryKey (Book book){
        return bookmappers.updateByPrimaryKey(book);
    }
}
