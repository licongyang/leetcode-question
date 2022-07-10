package com.licongyang.algorithm.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxyDemo {
    static class HelloImpl implements Hello {
        @Override
        public String sayHello(String user) {
            System.out.println(" hello impl ");
            return "hello" + user;
        }
    }

    static class JDKProxy<T> implements InvocationHandler {

        private T target;

        public JDKProxy(T object){
            this.target = object;
        }
        //proxy - the proxy instance that the method was invoked on也就是说，proxy应该是一个代理实例（动态代理类）
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            Object result = null;
            preOperation();
            result = method.invoke(target, args);
//        result = method.invoke(target, args);
            postOperation();
            return result;
        }

        private void preOperation() {
            System.out.println("前置处理");
        }

        private void postOperation() {
            System.out.println("后置处理");
        }
    }
    public static void main(String[] args) {

        // 真正实现类
        Hello hello = new HelloImpl();
        // 代理类
        Hello hi = (Hello)Proxy.newProxyInstance(
                JDKProxyDemo.class.getClassLoader(),
                new Class[]{Hello.class},
                new JDKProxy(hello));

        hi.sayHello("wang wu");
    }
}
