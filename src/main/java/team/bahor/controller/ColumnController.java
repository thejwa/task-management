package team.bahor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.dto.column.ColumnUpdateDto;
import team.bahor.service.column.ColumnService;
import team.bahor.utils.BaseUtils;

import javax.validation.Valid;

@Controller
@RequestMapping("/column/*")
public class ColumnController extends AbstractController<ColumnService> {

    @Autowired
    public ColumnController(ColumnService service) {
        super(service);
    }


    @RequestMapping(value = "create/{id}", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("dto") ColumnCreateDto dto, @PathVariable Long id) {
        dto.setProjectId(id);
        dto.setCreatedBy(BaseUtils.sessionUserId());
        service.create(dto);
        return "redirect:/project/"+id;
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public String get(Model model, @PathVariable Long id) {
        model.addAttribute("projectColumn", service.get(id));
        return "redirect:/";
    }
//
//    @RequestMapping(value = "getAll/{id}", method = RequestMethod.GET)
//    public String getAll(Model model, @PathVariable Long id) {
//        model.addAttribute("projectColumns", service.getAll(id));
//        return "redirect:/";
//    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.POST)
    public String update(@ModelAttribute ColumnUpdateDto dto, @PathVariable Long id) {
        service.update(dto);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.POST)
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/";
    }

}
