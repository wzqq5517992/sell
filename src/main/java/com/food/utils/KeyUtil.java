package com.food.utils;

import java.util.Random;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-07 23:26
 */
public class KeyUtil {

    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        System.out.println(number+"");
        return System.currentTimeMillis() + String.valueOf(number);
    }

    public static void main(String[] args) {
        System.out.println(genUniqueKey());
    }
}
