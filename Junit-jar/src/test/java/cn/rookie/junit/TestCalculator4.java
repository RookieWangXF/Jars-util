package cn.rookie.junit;

import cn.rookie.Calculator;
import junit.framework.Assert;
import org.junit.*;

/**
 * Created by Rookie on 2016/4/10.
 * Description:
 * Project_name: Jars
 * Copyright (c) All Rights Reserved.
 */

public class TestCalculator4 {
    private Calculator calculator;

    @BeforeClass
    public static void globalInit() {
        System.out.println("globalInit");
    }
    @Before
    public void setUp() {
        if (calculator == null) {
            calculator = new Calculator();
        }
    }
    //@Test(expected = Exception.class)
    @Test
    public void testAdd() {
        int res = calculator.add(2, 4);
        Assert.assertEquals(6, res);
    }

    @After
    public void tearDown() {
        System.out.println("执行结束了");
    }

    @AfterClass
    public static void globalDestory() {
        System.out.println("globalDestory");
    }
}
