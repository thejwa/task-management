package team.bahor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import team.bahor.dto.column.ColumnCreateDto;
import team.bahor.service.column.ColumnService;

@Controller
@RequestMapping("/column/*")
public class ColumnController extends AbstractController<ColumnService> {

    @Autowired
    public ColumnController(ColumnService service) {
        super(service);
    }


    @RequestMapping(value = "create/{id}", method = RequestMethod.POST)
    public String create(@ModelAttribute ColumnCreateDto dto, @PathVariable Long id) {
        dto.setCreatedBy(id);
        service.create(dto);
        return "redirect:/";
    }
}
