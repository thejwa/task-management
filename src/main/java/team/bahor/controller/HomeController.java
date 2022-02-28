package team.bahor.controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import team.bahor.config.security.UserDetails;
import team.bahor.enums.user.Roles;
import team.bahor.utils.BaseUtils;

@Controller
public class HomeController {

    //    @Secured("ROLE_SUPER_ADMIN")
    @GetMapping({"", "/home"})
    public String homePage() {
        if (BaseUtils.hasRole("SUPER_ADMIN")) return "forward:/organization/super_admins_page";
        if (BaseUtils.hasPermission("PROJECT_LIST"))
            return ("forward:/organization/get/" + BaseUtils.getSessionOrgId());
        if (BaseUtils.hasRole("USER")) return "forward:/user/user_page";
        return "404";
    }

    @GetMapping("/project")
    public String projectPage() {
        return "project";
    }

    @GetMapping("/task")
    public String taskPage() {
        return "task";
    }

    @GetMapping("/organization")
    public String adminPage() {
        return "home";
    }

    @GetMapping("/404")
    public String error() {
        return "404";
    }

}
