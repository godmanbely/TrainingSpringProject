package com.miluo.bookman.mapper;

import com.miluo.bookman.entity.Reader;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReaderMapper {
    int deleteByPrimaryKey(Integer studentId);

    int insert(Reader record);

    int insertSelective(Reader record);

    Reader selectByPrimaryKey(Integer studentId);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}