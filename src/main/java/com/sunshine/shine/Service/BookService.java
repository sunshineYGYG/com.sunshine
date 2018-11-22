package com.sunshine.shine.Service;

import com.mongodb.WriteResult;
import com.sunshine.shine.Module.Book;

import java.util.List;

public interface BookService {
    Book findOneBook(String id);

    List<Book> findBooks(String title,Integer price);

    void saveOneBook(Book book);

    WriteResult removeOneBook(String id);

    WriteResult updateOneBook(Book book);
}
