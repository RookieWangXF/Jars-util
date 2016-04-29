package cn.rookie.junit;

import cn.rookie.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Rookie on 2016/4/29.
 * Description: 使用参数化运行器运行
 * Project_name: Jars-util
 * Copyright (c) All Rights Reserved.
 */
@RunWith(Parameterized.class)
public class ParametesTest {
    private int expected;

    private int input1;

    private int input2;

    private Calculator cal;
    @Before
    public void init() {
        cal = new Calculator();
    }

    @Parameterized.Parameters
    public static Collection prepareData() {
        Object[][] objects = {{3,1,2},
                            {-4,1,-5},
                            {7,1,6},
                            {2,1,1}};
        return Arrays.asList(objects);
    }

    /**
     * 通过构造函数将每组参数注入的
     * @param expected
     * @param input1
     * @param input2
     */
    public ParametesTest(int expected, int input1, int input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    @Test
    public void testAdd() {
        Assert.assertEquals(this.expected,cal.add(input1, input2));

    }
    @Test
    public void testAdd2() {
        Assert.assertEquals(this.expected,cal.add(input1, input2));

    }
}
