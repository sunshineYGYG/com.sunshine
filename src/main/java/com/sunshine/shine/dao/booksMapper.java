package com.sunshine.shine.dao;

import com.sunshine.shine.dao.model.books;

public interface booksMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(books record);

    int insertSelective(books record);

    books selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(books record);

    int updateByPrimaryKey(books record);
}