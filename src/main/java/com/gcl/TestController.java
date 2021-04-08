package com.gcl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author：小关同学爱吃汉堡
 * @date: 2021/4/5 16:41
 */
//改变默认默认扫描路径测试
@RestController
public class TestController {
    @RequestMapping("/test")
    public String print(){
        return "666";
    }
}
