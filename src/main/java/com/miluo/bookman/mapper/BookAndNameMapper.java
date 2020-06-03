package com.miluo.bookman.mapper;

import com.miluo.bookman.entity.BookAndName;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookAndNameMapper {
    int insert(BookAndName record);

    int insertSelective(BookAndName record);

    int deletereader(Integer reader_id,Integer book_id);

    List<BookAndName> showbook(Integer reader_id);
}