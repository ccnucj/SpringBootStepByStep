package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
	@Action(name="add方法上的注解")
    public void add(){
	    System.out.println("现在正在执行DemoAnnotationService的add方法");
    }
   
}
