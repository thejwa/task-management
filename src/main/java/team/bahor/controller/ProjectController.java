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
import team.bahor.service.project.ProjectServiceImpl;

import javax.validation.Valid;

@Controller
@RequestMapping("/project/*")
public class ProjectController {
    private final ProjectServiceImpl projectServiceImpl;

    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }


    /*@RequestMapping(value = "create/{id}", method = RequestMethod.GET)
    public String createPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("dto", new TaskCreateDto(id));
        return "task/create";
    }
    @ResponseBody
    @RequestMapping(value = "create/{id}", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dto") TaskCreateDto dto, @PathVariable("id") Long id, BindingResult result) {
        if (result.hasErrors()) {
            return "task/create";
        }
        dto.setColumnId(id);
        service.create(dto);
        return "redirect:/home";
    }
*/


    @RequestMapping(value = "/create/{id}", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dto") ProjectCreateDto dto, BindingResult bindingResult,@PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) {
            return "project/createProject";
        }
        dto.setOrganizationId(id);
        projectServiceImpl.create(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    public String createPage(Model model, @PathVariable("id") Long id) {
        model.addAttribute("dto", new ProjectCreateDto(id));
        return "project/createProject";
    }


    @RequestMapping(value = "update{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable(name = "id") Long id) {
//        model.addAttribute("dto", projectServiceImpl.get(id));
        return "project/createProject";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@Valid @ModelAttribute("dto") ProjectUpdateDto dto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "project/createProject";
        }
        projectServiceImpl.update(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(name = "id") Long id) {
        projectServiceImpl.delete(id);
        return "redirect:/";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("project", projectServiceImpl.get(id));
        return "project";
    }

    @RequestMapping(value = "getAll/{id}", method = RequestMethod.POST)
    public String getAll(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("projects", projectServiceImpl.getAllTasksForColumn(id));
        return "redirect:/";
    }

}
