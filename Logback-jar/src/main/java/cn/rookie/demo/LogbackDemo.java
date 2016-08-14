package cn.rookie.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rookie on 2016/8/12.
 * Package_name is cn.rookie.demo
 * Description:
 */
public class LogbackDemo {

    private static Logger logger = LoggerFactory.getLogger(LogbackDemo.class);

    public static void main(String[] args) {
        logger.trace("=====trace");
        logger.debug("=====debug");
        logger.info("=====info");
        logger.warn("=====warn");
        logger.error("=====error");

        String name = "Aub";
        String message = "3Q";
        String[] fruits = {"apple", "banana","pear"};

        logger.info("hello {} !", name);
        logger.info("hello {},{} !", name,message);
        logger.info("Fruit: {},{},,{}", fruits);

    }
}
