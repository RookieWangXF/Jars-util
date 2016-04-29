package cn.rookie.junit;

import cn.rookie.Calculator;
import junit.framework.Assert;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Created by Rookie on 2016/4/10.
 * Description:
 * Project_name: Jars
 * Copyright (c) All Rights Reserved.
 */

public class TestCalculator4 {
    private Calculator calculator;

    /**
     * 仅仅执行一次
     * 方法是静态的
     */
    @BeforeClass
    public static void globalInit() {
        System.out.println("globalInit");
    }

    /**
     * 每个test都会执行一次
     */
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

    /**
     * 期望抛出异常
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void testDivide() throws Exception{
        calculator.divide(1, 0);
    }


    /**
     * 会忽略此类
     */
    @Test
    @Ignore
    public void testIgnore() {
        System.out.println("忽略了");
    }

}
