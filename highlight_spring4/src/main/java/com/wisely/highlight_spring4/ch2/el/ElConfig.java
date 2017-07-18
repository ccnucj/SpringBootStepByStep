package com.wisely.highlight_spring4.ch2.el;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

/**
 * spring 具备的各种资源属性的注入
 */
@Configuration
@ComponentScan("com.wisely.highlight_spring4.ch2.el")
@PropertySource("classpath:test.properties")//7
public class ElConfig {

    //直接用字符串赋值
    @Value("I Love You!") //1
    private String normal;

    //读取操作系统的属性值
    @Value("#{systemProperties['os.name']}") //2
    private String osName;

    //计算表达式的值
    @Value("#{ T(java.lang.Math).random() * 100.0 }") //3
    private double randomNumber;

    //引入bean的属性值
    @Value("#{demoService.another}") //4
    private String fromAnother;

    //加载文件，保存在Resource中
    @Value("classpath:test.txt") //5
    private Resource testFile;

    @Value("http://www.baidu.com") //6
    private Resource testUrl;

    /**
     * 直接读取配置文件的属性值
     * 这样生效的前提在于使用
     * （1）@PropertySource("classpath:test.properties")
     * （2） @Bean //7
     *       public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
     *       return new PropertySourcesPlaceholderConfigurer();
     *       }
     */
    @Value("${book.name}") //7
    private String bookName;

    /**
     * 将配置文件的属性值，直接注入到一个Environment中
     * 后续直接读取 如下：environment.getProperty("book.author")
     */
    @Autowired
    private Environment environment; //7

    @Bean //7
    public static PropertySourcesPlaceholderConfigurer propertyConfigure() {
        return new PropertySourcesPlaceholderConfigurer();
    }


    public void outputResource() {
        try {
            System.out.println(normal);
            System.out.println(osName);
            System.out.println(randomNumber);
            System.out.println(fromAnother);

            System.out.println(IOUtils.toString(testFile.getInputStream()));
            System.out.println(IOUtils.toString(testUrl.getInputStream()));
            System.out.println(bookName);
            System.out.println(environment.getProperty("book.author"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
