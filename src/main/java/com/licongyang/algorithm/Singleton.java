package com.licongyang.algorithm;

public class Singleton {
    // 考虑延迟加载 && 线程安全
    // 私有方法
    private Singleton(){}
    // 静态内部类 静态成员变量为单例实例
    private static class SingletonHolder{
        private static Singleton singleton = new Singleton();
    }
    // 静态获取方法
    public static Singleton getInstance(){
        return SingletonHolder.singleton;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance().hashCode());
        System.out.println(Singleton.getInstance().hashCode());
    }
}
