package com.sunshine.shine.Test.ThreadTest;

import com.sunshine.shine.Module.Book;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class ThreadTest {

    @Resource
    private HelpThread helpThread;

    @Resource
    private BookThread bookThread;

    @Resource
    private IUcService ucService;

    @GetMapping("/test/thread")
    public void test() throws InterruptedException{
        Book book =new Book();
        book.setId("1");
        String info = ucService.getInfo(book);
        System.out.println(info);

        Book book1 =new Book();
        book1.setId("1");
        String info1 = ucService.getInfo(book1);
        System.out.println(info1);

        Book book2 = new Book();
        book2.setId("2");

        bookThread.book = book;
        Thread thread = new Thread(bookThread);
        bookThread.book = book2;
        Thread thread1 = new Thread(bookThread);

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        return ;
    }

    @Test
    public void test2() throws InterruptedException{

        Book book = new Book();
        book.setId("1");
        Book book2 = new Book();
        book2.setId("2");

        BookThread bookThread = new BookThread();
        bookThread.book = book;
        Thread thread = new Thread(bookThread);


        BookThread bookThread1 = new BookThread();
        bookThread1.book = book2;
        Thread thread1 = new Thread(bookThread1);

        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        return ;
    }
}

