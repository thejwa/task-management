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

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

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

    @GetMapping("create_user/{id}")
    public String createUserPage(@PathVariable(value = "id") Long id, Model model) {
        UserCreateDto dto = UserCreateDto.builder().organizationId(id).build();
        model.addAttribute("dto", dto);
        return "user/create_user";
    }

    @PostMapping("/create_user/{id}")
    public String createUser(@ModelAttribute("dto") UserCreateDto dto, @PathVariable("id") Long id) {
        dto.setOrganizationId(id);
        dto.setRole(Roles.USER.getCode());
        service.create(dto);
        return "redirect:/home";
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
        final Long id = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        return "redirect:organization/getUser/" + id;
    }

    @RequestMapping(value = "/projectaddmember/{id}")
    public String projectAddMemberPage(@PathVariable(name = "id") Long id,Model model){
        model.addAttribute("users",service.getAllMemberForProject(id));
        model.addAttribute("id",id);
        return "project/addMember";
    }
    @RequestMapping(value = "/projectAddmember/{projectId}/{id}")
    public String projectAddMember(@PathVariable(name = "id") Long id, @PathVariable(name = "projectId") Long projectId, HttpServletRequest request){
        service.projectAddMember(id,projectId);
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "projectlistmember/{id}")
    public String getProjectAllMember(@PathVariable("id") Long id,Model model){
        model.addAttribute("users",service.getProjectAllMember(id));
        model.addAttribute("id",id);
        return "project/memberlist";

    }

    @RequestMapping(value = "/deletedprojectmember/{projectId}/{id}")
    public String deletedprojectmember(@PathVariable("id") Long id,@PathVariable("projectId") Long projectId,HttpServletRequest request){
        service.deletedprojectmember(id,projectId);
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "blockprojectmember/{projectId}/{id}")
    public String blocked(@PathVariable("id") Long id,@PathVariable("projectId") Long projectId,HttpServletRequest request){
        service.blockProjectmember(id,projectId);
        return "redirect:"+request.getHeader("Referer");
    }

    @RequestMapping(value = "taskMembers/{id}")
    public String getTaskMembers(@PathVariable("id") Long id,Model model){
        model.addAttribute("users",service.getTaskMembers(id));
        model.addAttribute("id",id);
        return "task/taskMemberslist";
    }

    @RequestMapping(value = "taskCanMembersList/{id}")
    public String taskCanMembersList(@PathVariable("id") Long id,Model model){
        model.addAttribute("users",service.taskCanMembersList(id));
        model.addAttribute("id",id);
        return "task/taskCanMembersList";
    }

}
