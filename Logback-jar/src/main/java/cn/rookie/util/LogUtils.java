package cn.rookie.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rookie on 2016/8/12.
 * Package_name is cn.rookie.util
 * Description:
 */
public class LogUtils {

    public static void main(String[] args) {
        String name = "feifei";
        Logger log = LoggerFactory.getLogger(LogUtils.class);
        log.info("feifei");
        log.warn("rookie");
        log.debug("11rookie");
    }
}
