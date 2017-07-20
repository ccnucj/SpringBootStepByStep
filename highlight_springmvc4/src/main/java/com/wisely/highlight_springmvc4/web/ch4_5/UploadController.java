package com.wisely.highlight_springmvc4.web.ch4_5;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class UploadController {

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody
    String upload(MultipartFile file, ServletRequest request) {//1

        /**
         * 解决上传文件，文件名乱码的问题
         * @author 陈杰【18571686146@163.com】
         * @Date 2017/7/19 17:05
         */
        try {
            System.out.println("默认的编码-->" + request.getCharacterEncoding());
            FileUtils.writeByteArrayToFile(new File("e:/upload/" + new String(file.getOriginalFilename().getBytes("ISO-8859-1"), "UTF-8")),
                    file.getBytes()); //2
            return "ok";
        } catch (IOException e) {
            e.printStackTrace();
            return "wrong";
        }


    }

}
