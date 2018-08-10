package com.wind.springbootmybatistransactionoptimisticlock.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class JSONUtil {

    private static final Logger logger = LoggerFactory.getLogger(JSONUtil.class);

    public static String toJSONString(Object object){

        String value = null;
        try {
            value = new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
