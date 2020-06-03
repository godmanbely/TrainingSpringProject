package com.miluo.bookman.service;


import com.miluo.bookman.entity.Book;
import com.miluo.bookman.entity.Reader;
import com.miluo.bookman.mapper.ReaderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class readerservice {
    @Autowired
    ReaderMapper readerMapper;

    public Reader selectbyReaderid(Integer student_id){
        return  readerMapper.selectByPrimaryKey(student_id);
    }
    public int updateByPrimaryKey(Reader reader){
        return  readerMapper.updateByPrimaryKey(reader);
    }

}
