package cn.rookie.demo;

import ch.qos.logback.classic.Level;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rookie on 2016/8/13.
 * Package_name is cn.rookie.demo
 * Description:
 */
public class LogbackDemoTest {

    @Before
    public void setUp() {

    }
    @Test
    public void level() {
        System.out.println(Level.toLevel(20000));

    }
}