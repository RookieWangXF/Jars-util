package cn.rookie;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Rookie on 2016/5/17.
 * Package_name is cn.rookie
 * Description:
 */
public class ProxyFactoryTest {

    @Test
    public void getProxyInstance() throws Exception {
        UserDao target = new UserDao();
        System.out.println(target.getClass());

        //设值代理
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());
        proxy.save();
        proxy.nothing();

        Assert.assertNotEquals(target.getClass(), proxy.getClass());
    }

}