package com.sunshine.shine.Service.impl;

import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;
import com.sunshine.shine.Module.Book;
import com.sunshine.shine.Service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("bookService")
public class BookServiceImpl implements BookService {
    private static final Logger LOGGER=LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Book findOneBook(String id) {
        return mongoTemplate.findById(id,Book.class);
    }

    @Override
    public List<Book> findBooks(String title, Integer price) {
        Criteria criteria=Criteria.where("title").regex(title).and("price").is(price);
        Query query=Query.query(criteria);//.limit().skip();
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }

    @Override
    public void saveOneBook(Book book) {
        mongoTemplate.save(book);
    }

    @Override
    public WriteResult removeOneBook(String id) {
        Criteria criteria=Criteria.where("_id").is(id);
        Query query=Query.query(criteria);
        WriteResult result = mongoTemplate.remove(query,Book.class);
        return result;
    }

    @Override
    public WriteResult updateOneBook(Book book) {
        Criteria criteria=Criteria.where("_id").is(book.getId());
        Query query=Query.query(criteria);
        Update update=Update.update("title",book.getTitle());
        update.set("price",book.getPrice());
        WriteResult result = mongoTemplate.updateFirst(query, update, Book.class);
        return result;
    }
}
