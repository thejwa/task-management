package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import team.bahor.service.user.UserServiceImpl;

@Controller
public class AuthController extends AbstractController<UserServiceImpl> {
    public AuthController(UserServiceImpl service) {
        super(service);
    }

    @GetMapping("/login")
    public String loginPage(){
        return "/login";
    }

    @GetMapping("/logout")
    public String logoutPage(){
        return "/logout";
    }




}
