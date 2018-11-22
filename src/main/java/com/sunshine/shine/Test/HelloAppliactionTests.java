package com.sunshine.shine.Test;

import com.sunshine.shine.Service.Sender;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes=ShineApplication.class)
public class HelloAppliactionTests {

    @Autowired
    private Sender sender;

//    @Test
    public void hello() throws Exception{
        sender.send();
    }
}
