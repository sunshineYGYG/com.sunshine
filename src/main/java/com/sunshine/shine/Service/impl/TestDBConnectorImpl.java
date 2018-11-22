package com.sunshine.shine.Service.impl;

import com.sunshine.shine.Service.DBConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by yangguang on 2018/5/28 下午9:39
 * modify history:
 *
 */
@Service("testDBConnector")
public class TestDBConnectorImpl implements DBConnector {
    private static final Logger LOGGER=LoggerFactory.getLogger(TestDBConnectorImpl.class);
    @Override
    public void configure() {
        LOGGER.info("test db");
    }
}
