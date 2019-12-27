package com.sunshine.shine.Test.ThreadTest;

import com.sunshine.shine.Module.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("ucServiceImpl")
public class UcServiceImpl implements IUcService{
    private static final Logger LOGGER = LoggerFactory.getLogger(UcServiceImpl.class);

    @Override
    public String getInfo(Book book) {
        LOGGER.info(this+" begin: " + LocalDateTime.now());
        synchronized (book) {
            try {
                LOGGER.info(this + "  id= " + book.getId() + "--1--");
                Thread.sleep(2*1000);
                if ("2".equals(book.getId())) {
//                    Thread.sleep(2 * 1000);
                } else {
//                    Thread.sleep(1 * 1000);
                }
                LOGGER.info(this + "  id= " + book.getId() + "--2--");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        LOGGER.info(this + " end: " + LocalDateTime.now());
        return book.getId();
    }
}
