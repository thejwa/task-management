package team.bahor.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import team.bahor.config.security.UserDetails;

@Controller
public class HomeController {
    @GetMapping(value = {"","/home"})
    public String homePage() {
        UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("principal.getId() = " + principal.getId());
        System.out.println("principal.getUsername() = " + principal.getUsername());
        System.out.println("principal.getAuthorities() = " + principal.getAuthorities());
        return "index";
    }

}
