package team.bahor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.dto.task.TaskCreateDto;
import team.bahor.dto.task.TaskUpdateDto;
import team.bahor.service.task.TaskServiceImpl;
import team.bahor.utils.BaseUtils;

import javax.validation.Valid;

@Controller
//@ResponseBody
@RequestMapping("/task/*")
public class TaskController {
    private final TaskServiceImpl service;

    public TaskController(TaskServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "create/{id}", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dto") TaskCreateDto dto, @PathVariable("id") Long id) {
        dto.setColumnId(id);
        service.create(dto);
        return "redirect:/project/"+service.getProjectIdByColumnId(id);
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updatePage(Model model, @PathVariable("id") Long id) {
        TaskUpdateDto dto = service.getUpdateDto(id);
        model.addAttribute("dto", dto);
        return "task/update";
    }

@ResponseBody
    @PostMapping(value = "/update/{id}")
    public String update(@Valid @ModelAttribute("dto") TaskUpdateDto dto,
                         @PathVariable("id") Long id,
                         BindingResult result) {
        if (result.hasErrors()) {
            return "task/update";
        }
        service.update(dto);
        return "/";
    }

    @GetMapping(value = "/deleteTask/{id}")
    public String deleted(@PathVariable("id") Long id) {
        service.delete(id);
        return "/";
    }

    @GetMapping(value = "/get/{id}")
    public String getTask(@PathVariable("id") Long id,Model model){
        model.addAttribute("task",service.get(id));
        return "task";
    }
}
