package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @ResponseBody
    @RequestMapping(value = "/test")
    public String testMethod(){

        return "hello.done";
    }

    @RequestMapping(value = "/login")
    public String testLogin(){

        return "/login";
    }
}