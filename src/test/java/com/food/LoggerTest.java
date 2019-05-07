package com.food;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@Data
public class LoggerTest {
    @Test
    public void test1() {
        String name = "";

        String password = "123456";
        log.debug("debug...");
        log.info("name: " + name.length() + " ,password: " + password);
        log.info("name: {}, password: {}", name, password);
        log.error("error...");
        log.warn("warn...");
    }

}
