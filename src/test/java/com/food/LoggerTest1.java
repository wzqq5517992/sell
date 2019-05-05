package com.food;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-05 23:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest1 {
    private  final Logger logger=LoggerFactory.getLogger(LoggerTest1.class);
    @Test
    public void test1() {
        logger.info("ssss");
    }

}
