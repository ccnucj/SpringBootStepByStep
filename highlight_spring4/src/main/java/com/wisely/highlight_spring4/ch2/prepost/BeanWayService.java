package com.wisely.highlight_spring4.ch2.prepost;

public class BeanWayService {
    public BeanWayService() {
        super();
        System.out.println("BeanWayService构造函数在运行");
    }

    public void init() {
        System.out.println("@Bean-init-method");
    }

    public void destroy() {
        System.out.println("@Bean-destory-method");
    }
}
