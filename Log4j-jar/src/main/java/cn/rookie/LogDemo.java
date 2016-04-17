package cn.rookie;


import org.apache.log4j.Logger;

/**
 * Created by Rookie on 2016/4/10.
 * Description:
 * Project_name: Jars
 * Copyright (c) All Rights Reserved.
 */
public class LogDemo {
    private static Logger logger = Logger.getLogger(LogDemo.class);

    public static void main(String[] args) {
        logger.debug("This is a debug message");
        logger.info("This is a info message");
        logger.error("This is a error message");
    }
}
