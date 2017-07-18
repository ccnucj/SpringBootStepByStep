package com.wisely.highlight_spring4.ch2.prepost;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class JSR250WayService {
    public JSR250WayService() {
        super();
        System.out.println("JSR250WayService构造函数在运行");
    }

    @PostConstruct //他是在构造函数之后运行的
    public void init() {
        System.out.println("jsr250-init-method");
    }

    @PreDestroy //2
    public void destroy() {
        System.out.println("jsr250-destory-method");
    }

}
