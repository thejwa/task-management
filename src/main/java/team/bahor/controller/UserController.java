package team.bahor.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.service.user.UserServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/*")
public class UserController extends AbstractController<UserServiceImpl> {
    public UserController(UserServiceImpl service) {
        super(service);
    }

    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @GetMapping("create_admin/{id}")
    public String createAdminPage(@PathVariable(value = "id") Long id, Model model){
        UserCreateDto dto = UserCreateDto.builder().organization_id(id).build();
        model.addAttribute("dto", dto);
        return "user/create_admin";
    }

    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PostMapping("create_admin")
    public String createAdmin(@Valid @ModelAttribute("dto") UserCreateDto dto){

        return "redirect:admin";
    }

    @GetMapping("super_admins_page")
    public String superAdminsPage(Model model){
        return "admin";
    }

    @GetMapping("admins_page")
    public String adminsPage(Model model){
        return "admin";
    }
}
