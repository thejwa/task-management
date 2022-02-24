package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/project/*")
public class ProjectController {
    @RequestMapping("create")
    public String createProject() {
        return "/project/createProject.html";
    }

    @RequestMapping("update")
    public String updateProject(){
        return "/project/updateProject.html";
    }
}
