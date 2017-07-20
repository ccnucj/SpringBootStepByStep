package com.wisely.highlight_springmvc4.web.ch4_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * 服务器端主动推送事件
 * 只支持新式的浏览器比如chrome和firefox
 * 实现sse-->server send event 有两点需要实现
 * （1）服务端表明  produces="text/event-stream"
 * （2）页面上的js代码，如sse.jsp上
 */
@Controller
public class SseController {
	
	@RequestMapping(value="/push",produces="text/event-stream") //1
	public @ResponseBody String push(){
		 Random r = new Random();
        try {
                Thread.sleep(5000);
        } catch (InterruptedException e) {
                e.printStackTrace();
        }   
        return "data:Testing 1,2,3" + r.nextInt() +"\n\n";
	}

}
