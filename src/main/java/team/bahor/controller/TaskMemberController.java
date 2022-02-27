//package team.bahor.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import team.bahor.dto.task.TaskMemberCreateDto;
//import team.bahor.service.taskMember.TaskMemberServiceImp;
//
//
//@Controller
//@RequestMapping("/taskMember/*")
//public class TaskMemberController {
//    private final TaskMemberServiceImp service;
//
//    public TaskMemberController(TaskMemberServiceImp service) {
//        this.service = service;
//    }
//
//    @RequestMapping(value = "/add_member/{task_id}", method = RequestMethod.GET)
//    public String addMemberTaskPage(Model model, @PathVariable("task_id") Long taskId) {
//        model.addAttribute("dto", new TaskMemberCreateDto(taskId));
//        return "task/add_member_task";
//    }
//
//    @RequestMapping(value = "/add_member/{task_id}", method = RequestMethod.POST)
//    public String addMemberTask(@PathVariable("task_id") Long taskId,
//                                @ModelAttribute("dto") TaskMemberCreateDto dto,
//                                BindingResult result) {
//        if (result.hasErrors()) {
//            return "task/add_member_task";
//        }
//        service.create(dto);
//        return "/";
//    }
//    @GetMapping(value = "/delete/{id}")
//    public String deletedTaskMember(@PathVariable("id") Long id) {
//        service.delete(id);
//        return "/";
//    }
//
//    @GetMapping(value = "/allTaskMember/{id}")
//    public String allTaskMember(@PathVariable("id") Long id,Model model) {
//        model.addAttribute("allTaskMember",service.getAll(id));
//        return "/";
//    }
//}
