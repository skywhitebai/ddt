package com.sky.ddt.controller;

import com.sky.ddt.common.annotation.Action;
import com.sky.ddt.common.annotation.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("tool")
public class ToolController {
    @RequestMapping("/size")
    @Login(action = Action.Skip)
    public  String index(){
        return "tool/size";
    }
}
