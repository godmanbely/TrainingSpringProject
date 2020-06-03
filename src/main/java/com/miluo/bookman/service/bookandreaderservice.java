package com.miluo.bookman.service;

import com.miluo.bookman.entity.Book;
import com.miluo.bookman.entity.BookAndName;
import com.miluo.bookman.entity.Reader;
import com.miluo.bookman.mapper.BookAndNameMapper;
import com.miluo.bookman.mapper.BookMapper;
import com.miluo.bookman.mapper.ReaderMapper;
import com.miluo.bookman.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
 100 该书不存在
 */
@Service
@Transactional
public class bookandreaderservice {
    @Autowired
    BookAndNameMapper bookAndNameMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    ReaderMapper readerMapper;

    public Result insert(Integer reader_id, Integer book_id) {
        Book book = bookMapper.selectByPrimaryKey(book_id);
        if (book == null){
            return new Result(100,"该书不存在");
        }
        Reader reader = readerMapper.selectByPrimaryKey(reader_id);

        if (reader.getCount() >= 5 || book.getBorrowflag() == 1) {
            return new Result(101,"超过借书数量或书已经被借出");
        } else {
            book.setBorrowflag(1);
            reader.setCount(reader.getCount() + 1);
            bookMapper.updateByPrimaryKey(book);
            readerMapper.updateByPrimaryKey(reader);
            BookAndName bookAndName = new BookAndName(reader_id, book_id);
            bookAndNameMapper.insert(bookAndName);
            return  new Result(200,"借书成功");
        }
    }

    public Result delete(Integer reader_id, Integer book_id) {
        Book book = bookMapper.selectByPrimaryKey(book_id);
        if (book == null){
            return new Result(100,"该书不存在");
        }
        Reader reader = readerMapper.selectByPrimaryKey(reader_id);
        if (reader.getCount() == 0) {
            return new Result(103,"您没有借过书");
        } else {
            int flag = bookAndNameMapper.deletereader(reader_id, book_id);
            if (flag == 0) {
                return new Result(104,"没有借该书");
            } else {
                book.setBorrowflag(0);
                reader.setCount(reader.getCount() - 1);
                bookMapper.updateByPrimaryKey(book);
                readerMapper.updateByPrimaryKey(reader);
                return new Result(204,"还书成功");
            }
        }
    }
    public List<BookAndName> showbook (Integer reader_id){
        return bookAndNameMapper.showbook(reader_id);
    }

}
