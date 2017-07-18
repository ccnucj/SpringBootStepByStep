package com.wisely.highlight_spring4.ch2.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * prototype 每次调用生成一个bean
 */
@Service
@Scope("prototype")//1
public class DemoPrototypeService {

}
