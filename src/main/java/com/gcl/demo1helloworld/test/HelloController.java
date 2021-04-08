package com.gcl.demo1helloworld.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：小关同学爱吃汉堡
 * @date: 2021/4/3 16:16
 */
//@RestController是@ResponseBody注解和@Controller注解的合体，
//在类的上面直接使用@RestController，以后下面就可以不用@ResponseBody注解了
@RestController
@EnableAutoConfiguration
public class HelloController {

    //@ResponseBody注解表示返回给浏览器一个字符串，而不是跳转到哪个页面
    //@ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "你好,SpringBoot!!!";
    }
}
