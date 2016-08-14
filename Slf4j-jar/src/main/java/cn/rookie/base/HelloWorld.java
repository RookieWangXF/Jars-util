package cn.rookie.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rookie on 2016/8/10.
 * Package_name is cn.rookie.base
 * Description:
 */
public class HelloWorld {

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.info("Hello World");

    }
}
