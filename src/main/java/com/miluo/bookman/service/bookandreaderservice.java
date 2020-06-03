package com.miluo.bookman.service;

import com.miluo.bookman.entity.Book;
import com.miluo.bookman.entity.BookAndName;
import com.miluo.bookman.entity.Reader;
import com.miluo.bookman.mapper.BookAndNameMapper;
import com.miluo.bookman.mapper.BookMapper;
import com.miluo.bookman.mapper.ReaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class bookandreaderservice {
    @Autowired
    BookAndNameMapper bookAndNameMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    ReaderMapper readerMapper;

    public String insert(Integer reader_id, Integer book_id) {
        Book book = bookMapper.selectByPrimaryKey(book_id);
        if (book == null){
            return new StringBuffer("该书不存在").toString();
        }
        Reader reader = readerMapper.selectByPrimaryKey(reader_id);

        if (reader.getCount() >= 5 || book.getBorrowflag() == 1) {
            return new StringBuffer("超过借书数量或书已经被借出").toString();
        } else {
            book.setBorrowflag(1);
            reader.setCount(reader.getCount() + 1);
            bookMapper.updateByPrimaryKey(book);
            readerMapper.updateByPrimaryKey(reader);
            BookAndName bookAndName = new BookAndName(reader_id, book_id);
            bookAndNameMapper.insert(bookAndName);
            return new StringBuffer("借书成功").toString();
        }
    }

    public String delete(Integer reader_id, Integer book_id) {
        Book book = bookMapper.selectByPrimaryKey(book_id);
        if (book == null){
            return new StringBuffer("该书不存在").toString();
        }
        Reader reader = readerMapper.selectByPrimaryKey(reader_id);
        if (reader.getCount() == 0) {
            return new StringBuffer("您没有借过书").toString();
        } else {
            int flag = bookAndNameMapper.deletereader(reader_id, book_id);
            if (flag == 0) {
                return new StringBuffer("没有借该书").toString();
            } else {
                book.setBorrowflag(0);
                reader.setCount(reader.getCount() - 1);
                bookMapper.updateByPrimaryKey(book);
                readerMapper.updateByPrimaryKey(reader);
                return new StringBuffer("还书成功").toString();
            }
        }
    }
    public List<BookAndName> showbook (Integer reader_id){
        return bookAndNameMapper.showbook(reader_id);
    }

}
