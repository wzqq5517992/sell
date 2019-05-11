package com.food.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author wzq.Jolin
 * @company none
 * @create 2019-05-10 12:10
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
