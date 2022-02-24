package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import team.bahor.dto.organization.OrganizationCreatoDto;
import team.bahor.dto.organization.OrganizationUpdateDto;
import team.bahor.service.OrganizationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/organization/*")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage(Model model) {
        model.addAttribute("dto", new OrganizationCreatoDto());
        return "org/createOrg.html";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dto") OrganizationCreatoDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "org/createOrg.html";
        }
        organizationService.create(dto);
        return "redirect:/templates/index.html";
    }

    @RequestMapping(value = "update{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("dto", organizationService.get(id));
        return "org/updateOrg.html";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("dto") OrganizationUpdateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "org/updateOrg.html";
        }
        organizationService.update(dto);
        return "redirect:/templates/index.html";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") Long id){
        organizationService.delete(id);
        return "redirect:/templates/index.html";
    }
}
