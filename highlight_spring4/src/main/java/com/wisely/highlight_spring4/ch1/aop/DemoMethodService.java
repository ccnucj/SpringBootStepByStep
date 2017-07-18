package com.wisely.highlight_spring4.ch1.aop;

import org.springframework.stereotype.Service;

@Service
public class DemoMethodService {
	public void add(){
		System.out.println("现在正在执行DemoMethodService的add方法");
	}
}
