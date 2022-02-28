package team.bahor.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import team.bahor.config.security.UserDetails;
import team.bahor.dto.user.UserCreateDto;
import team.bahor.enums.user.Roles;
import team.bahor.service.organization.OrganizationServiceImpl;
import team.bahor.service.user.UserServiceImpl;
import team.bahor.utils.BaseUtils;

@Controller
@RequestMapping("/user/*")
public class UserController extends AbstractController<UserServiceImpl> {
    private final OrganizationServiceImpl organizationService;

    public UserController(UserServiceImpl service, OrganizationServiceImpl organizationService) {
        super(service);
        this.organizationService = organizationService;
    }

    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @GetMapping("create_admin/{org_id}")
    public String createAdminPage(@PathVariable(value = "org_id") Long orgId, Model model) {
        UserCreateDto dto = UserCreateDto.builder().organizationId(orgId).build();
        model.addAttribute("dto", dto);
        return "user/create_admin";
    }

    //    @PreAuthorize(value = "hasRole('SUPER_ADMIN')")
    @PostMapping("/create_admin/{org_id}")
    public String createAdmin(@ModelAttribute("dto") UserCreateDto dto, @PathVariable("org_id") Long orgId) {
        if (!BaseUtils.hasRole(Roles.SUPER_ADMIN.getCode()))
            return "404";
        dto.setOrganizationId(orgId);
        dto.setRole(Roles.ADMIN.getCode());
        service.create(dto);
        return "redirect:/home";
    }


    @GetMapping("create_user/{org_id}")
    public String createUserPage(@PathVariable(value = "org_id") Long orgId, Model model) {
        if (!BaseUtils.hasRole("ADMIN")) return "redirect:/home";
        UserCreateDto dto = UserCreateDto.builder().organizationId(orgId).build();
        model.addAttribute("dto", dto);
        return "user/create_user";
    }

    @PostMapping("create_user/{org_id}")
    public String createUser(@ModelAttribute("dto") UserCreateDto dto, @PathVariable(value = "org_id") Long orgId) {
        dto.setOrganizationId(orgId);
        service.create(dto);
        return "redirect:/home";
    }


//    @GetMapping("admins_page")
//    public String adminsPage(Model model) {
//        final Long id = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getOrganizationId();
//        return "forward:organization/get/" + id;
//    }

    @GetMapping("user_page")
    public String userPage(Model model) {
        final Long id = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return "forward:organization/getUser/" + id;
    }


}
