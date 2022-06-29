package bg.nbu.cscb634.onlinegradebook.controller;

import bg.nbu.cscb634.onlinegradebook.model.Parent;
import bg.nbu.cscb634.onlinegradebook.services.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ParentController {
    @Autowired
    private ParentService parentServices;

    @GetMapping(path = "/parents")
    public String showParentsPage(Model model) {
        List<Parent> parents = parentServices.findAll();
        model.addAttribute("parents", parents);
        return "parents";
    }

    @GetMapping(path = "/parents/add")
    public String showAddParentPage(Model model) {
        model.addAttribute("parent", new Parent());
        return "parents-add";
    }

    @PostMapping(path = "/parents/add")
    public String addParent(@ModelAttribute Parent parent) {
        parentServices.addParent(parent);
        return "redirect:/parents";
    }

    @GetMapping("/parents/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Parent parent = parentServices.findParentById(id);
        model.addAttribute("parent", parent);
        return "parents-edit";
    }

    @PostMapping("/parents/edit/{id}")
    public String updateParent(@ModelAttribute Parent parent) throws Exception {
        parentServices.updateParent(parent);
        return "redirect:/parents";
    }

    @GetMapping("/parents/delete/{id}")
    public String deleteParent(@PathVariable("id") int id) {
        parentServices.deleteParent(id);
        return "redirect:/parents";
    }
}
