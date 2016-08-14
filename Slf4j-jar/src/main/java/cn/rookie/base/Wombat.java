package cn.rookie.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintStream;

/**
 * Created by Rookie on 2016/8/10.
 * Package_name is cn.rookie.base
 * Description:
 */
public class Wombat {

    //不管用
    static {
        System.setProperty("SHOW_DATE_TIME", "true");
        System.setProperty("SHOW_SHORT_LOG_NAME", "true");
    }

    final Logger logger = LoggerFactory.getLogger("DEBUG");
    Integer t;
    Integer oldT;

    public void setTemperature(Integer temperature) {

        oldT = t;
        t = temperature;

        logger.debug("Temperature set to {}. Old temperature was {}.", t, oldT);
        if (temperature.intValue() > 50) {
            logger.info("Temperature has risen above 50 degrees.");
        }

        logger.info("rookie");

        logger.error("adfasdfa",oldT);
    }

    public static void main(String[] args) {
        /*Wombat wombat = new Wombat();
        wombat.setTemperature(60);
        PrintStream printStream = System.err.append("xc");
        printStream.print("a");
        PrintStream printStream2 = System.out.append("xc");
        printStream2.print("a");
*/
        LoggerFactory.getLogger(Wombat.class);
        Wombat.class.getName();
        System.out.println("---"  );
    }
}
