package cn.rookie.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by Rookie on 2016/4/29.
 * Description:此Suite可以是一个单个的类，用来包装运行其他的类，本身也可以是测试类被其他的组件运行
 * 这是典型的组合设计模式
 * Project_name: Jars-util
 * Copyright (c) All Rights Reserved.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ParametesTest.class,TestCalculator.class,TestCalculator4.class})
public class TestAll {

}
