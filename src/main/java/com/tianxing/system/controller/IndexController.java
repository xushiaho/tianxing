package com.tianxing.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>  </p>
 *
 * @program: tianxing
 * @author: 许仕昊
 * @create: 2019-12-23 23:26
 **/

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }
}
