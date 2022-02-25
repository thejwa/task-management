package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"", "/home"})
    public String homePage() {
        return "home";
    }

    @GetMapping("/project")
    public String projectPage() {
        return "project";
    }

    @GetMapping("/task")
    public String taskPage() {
        return "task";
    }

}
