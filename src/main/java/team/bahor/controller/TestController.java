package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
    @RequestMapping(value = {"/test", }, method = RequestMethod.GET)
    public String organizationPage() {
        return "/index";
    }
    @RequestMapping(value = {"/login", }, method = RequestMethod.GET)
    public String projectPage() {
        return "/login";
    }

    @RequestMapping(value = "/login")
    public String testLogin(){

        return "/login";
    }
}
