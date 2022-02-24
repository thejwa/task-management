package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    @RequestMapping("/organization/*")
public class OrganizationController {

    @RequestMapping("/create")
    public String homePAge() {
        return "redirect:/templates/createOrg.html";
    }

}
