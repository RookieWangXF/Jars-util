package cn.rookie.junit;

import cn.rookie.Calculator;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by Rookie on 2016/4/9.
 * Description:测试类要分开与源代码;
 *  3.8.1
 *  测试的3.8的junit类型
 *
 * Project_name: Jars
 * Copyright (c) All Rights Reserved.
 */
public class TestCalculator extends TestCase{

    private Calculator calculator;

    /**
     * 1. 使用断言判断是否是正确的
     */
    public void testAdd(){
        int result = calculator.add(1, 2);
        Assert.assertEquals(3, result);
    }
    public void testSubtract(){
        int result = calculator.subtract(3, 2);
        Assert.assertEquals(1, result);
    }

    public void testMultiply(){
        int result = calculator.multiply(3, 2);
        Assert.assertEquals(6, result);
    }
    public void testDivide(){
        int result = calculator.divide(4, 2);
        Assert.assertEquals(2, result);
    }


    @Override
    protected void setUp() throws Exception {
        //System.out.println("setUp");
        calculator = new Calculator();
    }

    @Override
    protected void tearDown() throws Exception {
        //System.out.println("tearDown");
    }

    public void testDivideByZero(){
        Throwable tx = null;
        try {
            calculator.divide(4, 0);
        } catch (Exception ex) {
            tx = ex;
        }

        Assert.assertEquals(ArithmeticException.class, tx.getClass());

    }

    public void testNotNUll(){
        Assert.assertNotNull("kong",calculator);
    }

    /**
     * 测试失败的例子
     */
    public void testFail() {
        try {
            int arr[] = new int[0];
            arr[1] = 1;
        } catch (Exception e) {
            Assert.fail("失败了"+ e.toString());
        }

    }
}
