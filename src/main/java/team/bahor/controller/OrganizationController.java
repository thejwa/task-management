package team.bahor.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import team.bahor.dto.organization.OrganizationCreatoDto;
import team.bahor.dto.organization.OrganizationDto;
import team.bahor.dto.organization.OrganizationUpdateDto;
import team.bahor.service.organization.OrganizationServiceImpl;
import team.bahor.utils.BaseUtils;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController {
    private final OrganizationServiceImpl organizationService;

    public OrganizationController(OrganizationServiceImpl organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage(Model model) {
        model.addAttribute("dto", new OrganizationCreatoDto());
        return "org/createOrg";
    }

    //
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dto") OrganizationCreatoDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "org/createOrg";
        }
        dto.setCreatedBy(BaseUtils.sessionUserId());
        organizationService.create(dto);
        return "redirect:/";
    }

    @GetMapping("super_admins_page")
    public String superAdminsPage(Model model) {
        List<OrganizationDto> organizations = organizationService.getAll();
        model.addAttribute("organizations", organizations);
        return "admin";
    }
//
//    @RequestMapping(value = "update{id}", method = RequestMethod.GET)
//    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
//        model.addAttribute("dto", organizationService.get(id));
//        return "org/createOrg";
//    }
//
//    @RequestMapping(value = "update", method = RequestMethod.POST)
//    public String update(@Valid @ModelAttribute("dto") OrganizationUpdateDto dto, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "org/createOrg";
//        }
//
//        organizationService.update(dto);
//        return "/";
//    }
//
//    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
//    public String delete(@PathVariable(name = "id") Long id){
//        organizationService.delete(id);
//        return "/";
//    }
//
//    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
//    public String getAll(Model model, @PathVariable(name = "id") Long id) {
//        model.addAttribute("organization", organizationService.get(id));
//        return "redirect:/home";
//    }
//

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String getOrg(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", organizationService.get(id));
        return "home";
    }

    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public String getUserOrg(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("organization", organizationService.getOrg(id));
        return "home";
    }
}
