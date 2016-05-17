package cn.rookie;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Rookie on 2016/5/17.
 * Package_name is cn.rookie
 * Description: cglib子类代理工厂
 */
public class ProxyFactory implements MethodInterceptor{

    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始事务.....");

        // 执行目标对象的方法
        Object returnValue = method.invoke(target, objects);

        System.out.println("提交事务.....");

        return returnValue;
    }

    //给目标对象，生成代理对象
    public Object getProxyInstance() {
        //1. 工具类
        Enhancer en = new Enhancer();
        //2. 设值父类
        en.setSuperclass(target.getClass());
        //3. 设值回调函数,当执行代理对象的任何方法的时候，都会执行上边的intercept
        en.setCallback(this);
        //4. 创建子类（代理对象）
        return en.create();
    }

}
