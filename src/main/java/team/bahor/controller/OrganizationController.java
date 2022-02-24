package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    @RequestMapping("/organization/*")
public class OrganizationController {

    @RequestMapping("create")
    public String createOrg() {
        return "/org/createOrg.html";
    }

    @RequestMapping("update")
    public String updateOrg(){
        return "/org/updateOrg.html";
    }

}
