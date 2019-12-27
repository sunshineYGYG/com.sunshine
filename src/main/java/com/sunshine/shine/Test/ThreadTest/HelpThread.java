package com.sunshine.shine.Test.ThreadTest;

import com.sunshine.shine.Module.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("helpThread")
public class HelpThread {
    public static final Logger LOGGER = LoggerFactory.getLogger(HelpThread.class);

    public String s;

    public void help(Book book) {
        LOGGER.info("begin: " + LocalDateTime.now());
        LOGGER.info("this: "+this);
//        synchronized (book) {
            try {
                if ("2".equals(book.getId())) {

                } else {
                    Thread.sleep(3 * 1000);
                }
                LOGGER.info("id= " + book.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//        }
        LOGGER.info("end: " + LocalDateTime.now());
    }
}
