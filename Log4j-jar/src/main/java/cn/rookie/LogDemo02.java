package cn.rookie;

import org.apache.log4j.Logger;

/**
 * Created by Rookie on 2016/4/10.
 * Description:
 * Project_name: Jars
 * Copyright (c) All Rights Reserved.
 */
public class LogDemo02 {
    private static Logger logger = Logger.getLogger(LogDemo02.class);

    public static void main(String[] args) {
        logger.debug("LogDemo02 This is a debug message");
        logger.info("LogDemo02 This is a info message");
        logger.error("LogDemo02 This is a error message");
    }
}
