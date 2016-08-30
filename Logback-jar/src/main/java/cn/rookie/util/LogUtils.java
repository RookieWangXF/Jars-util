package cn.rookie.util;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rookie on 2016/8/12.
 * Package_name is cn.rookie.util
 * Description:
 */
public class LogUtils {

    public static void main(String[] args) {
        Logger log = LoggerFactory.getLogger(LogUtils.class);
        Logger cn = LoggerFactory.getLogger("cn");
        /*LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(context);*/
        log.trace("adsfa");
        log.info("feifei");
        log.warn("rookie");
        log.debug("11rookie");
        cn.warn("nihao");
    }
}
