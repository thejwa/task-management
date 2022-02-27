package team.bahor.controller;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import team.bahor.config.security.UserDetails;
import team.bahor.enums.user.Roles;

@Controller
public class HomeController {

    @GetMapping({"", "/home"})
    public String homePage() {
        if (SecurityContextHolder.getContext().getAuthentication().getAuthorities()
                .contains(new SimpleGrantedAuthority("ROLE_" + Roles.SUPER_ADMIN.getCode())))
            return "forward:/user/super_admins_page";
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("principal.getId() = " + principal.getId());
        System.out.println("principal.getUsername() = " + principal.getUsername());
        System.out.println("principal.getAuthorities() = " + principal.getAuthorities());
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

    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }

}
