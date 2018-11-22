package com.sunshine.shine.controller;

import com.sunshine.shine.Module.Book;
import com.sunshine.shine.Service.BookService;
import com.sunshine.shine.Util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RequestMapping("/book")
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/getOneBook")
    public JsonData getOneBook(String id){
        return JsonData.success(bookService.findOneBook(id));
    }

    @GetMapping("/getBooks")
    public JsonData getBooks(String title,Integer price){
        return JsonData.success(bookService.findBooks(title,price));
    }

    @PostMapping("/saveOneBook")
    public JsonData saveOneBook(@RequestBody Book book){
        bookService.saveOneBook(book);
        return JsonData.success();
    }

    @PostMapping("/removeOneBook")
    public JsonData removeOneBook(String id){
        return JsonData.success(bookService.removeOneBook(id));
    }

    @PostMapping("/updateOneBook")
    public JsonData updateOneBook(@RequestBody Book book){
        return JsonData.success(bookService.updateOneBook(book));
    }
}
