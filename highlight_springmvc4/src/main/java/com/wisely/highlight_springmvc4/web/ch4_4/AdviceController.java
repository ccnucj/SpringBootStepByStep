package com.wisely.highlight_springmvc4.web.ch4_4;

import com.wisely.highlight_springmvc4.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdviceController {

    /**
     * @param msg
     * @param obj  会自动匹配url里面对应的属性 如 xxxx?id=123&name=chenjie，会自动映射到obj对应的属性中
     * @return
     */
    //此处使用了在ControllerAdvice里声明的全局键值对
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj) {//1
        System.out.println(obj);
        throw new IllegalArgumentException("非常抱歉，参数有误/" + "来自@ModelAttribute:" + msg);
    }

}
