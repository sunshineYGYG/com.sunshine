package com.sunshine.shine.Test.ThreadTest;

import com.sunshine.shine.Module.Book;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;


@Component
public class BookThread implements Runnable {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookThread.class);

    public Book book;

    @Autowired
    public IUcService ucService;

    @Override
    public void run() {
//        String info = ucService.getInfo(book);
//        System.out.println(info + " -1");
//        String info1 = ucService.getInfo(book);
//        System.out.println(info1+" -2");
        LOGGER.info(this+" begin: " + LocalDateTime.now());
        synchronized ("1") {
        try {
            LOGGER.info(this + "  id= " + book.getId() + "--1--");
            if ("2".equals(book.getId())) {

            } else {
                Thread.sleep(3 * 1000);
            }
            LOGGER.info(this + "  id= " + book.getId() + "--2--");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
        LOGGER.info(this + " end: " + LocalDateTime.now());
    }
}
