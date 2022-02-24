package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import team.bahor.dto.project.ProjectCreateDto;
import team.bahor.dto.project.ProjectUpdateDto;
import team.bahor.service.ProjectService;

import javax.validation.Valid;

@Controller
@RequestMapping("/project/*")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createPage(Model model) {
        model.addAttribute("dto", new ProjectCreateDto());
        return "project/createProject.html";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dto") ProjectCreateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "project/createProject.html";
        }
        projectService.create(dto);
        return "redirect:/templates/index.html";
    }

    @RequestMapping(value = "update{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("dto", projectService.get(id));
        return "project/updateProject.html";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("dto") ProjectUpdateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "project/updateProject.html";
        }
        projectService.update(dto);
        return "redirect:/templates/index.html";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") Long id){
        projectService.delete(id);
        return "redirect:/templates/index.html";
    }
}
