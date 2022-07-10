package com.licongyang.algorithm.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLIB(Code Generation Library)是一个基于ASM的字节码生成库，
 * 它允许我们在运行时对字节码进行修改和动态生成。CGLIB通过继承方式实现代理
 */
public class CglibDemo {

    static class Car{
        public void run(){
            System.out.println(" the car is running");
        }
    }

    static class CglibProxy<T> implements MethodInterceptor {
        // 代理对象
        private T target;

        public T getInstance(T target) {
            this.target = target;
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(this.target.getClass());
            enhancer.setCallback(this);
            return (T) (enhancer.create());
        }

        @Override
        public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {

            preOperation();
            Object o = method.invoke(target, args);
//            Object o = proxy.invoke(target, args);
            postOperation();

            return o;
        }

        private void preOperation() {
            System.out.println("前置处理");
        }

        private void postOperation() {
            System.out.println("后置处理");
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        CglibProxy<Car> cglibProxy = new CglibProxy<>();
        Car proxy = cglibProxy.getInstance(car);
        proxy.run();
    }
}