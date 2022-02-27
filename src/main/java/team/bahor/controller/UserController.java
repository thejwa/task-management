package team.bahor.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import team.bahor.config.security.UserDetails;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.enums.user.Roles;
import team.bahor.service.organization.OrganizationServiceImpl;
import team.bahor.service.user.UserServiceImpl;
import team.bahor.utils.BaseUtils;

import javax.validation.Valid;

@Controller
@RequestMapping("/user/*")
public class UserController extends AbstractController<UserServiceImpl> {
    private final OrganizationServiceImpl organizationService;

    public UserController(UserServiceImpl service, OrganizationServiceImpl organizationService) {
        super(service);
        this.organizationService = organizationService;
    }

    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @GetMapping("create_admin/{id}")
    public String createAdminPage(@PathVariable(value = "id") Long id, Model model) {
        UserCreateDto dto = UserCreateDto.builder().organizationId(id).build();
        model.addAttribute("dto", dto);
        return "user/create_admin";
    }

    //    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PostMapping("/create_admin/{id}")
    public String createAdmin(@ModelAttribute("dto") UserCreateDto dto, @PathVariable("id") Long id) {
        if (!BaseUtils.hasRole(Roles.SUPER_ADMIN.getCode()))
            return "404";
        dto.setOrganizationId(id);
        dto.setRole(Roles.ADMIN.getCode());
        service.create(dto);
        return "redirect:/home";
    }


    @GetMapping("admins_page")
    public String adminsPage(Model model) {
        final Long id = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getOrganizationId();
        return "redirect:organization/get/" + id;
    }

    @GetMapping("user_page")
    public String userPage(Model model) {
        return "home";
    }


}
