package com.miluo.bookman.mapper;

import com.miluo.bookman.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface BookMapper {
    int deleteByPrimaryKey(Integer bookId);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookId);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    Book selectByBookName(String bookName);

    List<Book> selectByWriterName(String writerName);
}