package org.launchcode.codingevents.controllers;
import org.launchcode.codingevents.data.EventCategoryRepository;
import org.launchcode.codingevents.models.EventCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("eventcategories")
public class EventCategoryController {

    @Autowired
    public EventCategoryRepository eventCategoryRepository;


    @GetMapping("")
    public String displayAllEventCategories(Model model) {
        model.addAttribute("title", "All Categories");
        model.addAttribute("eventCategories", eventCategoryRepository.findAll());
        return "eventcategories/index";
    }

    @GetMapping("create")
    public String renderCreateEventCategoryForm(Model model) {
        model.addAttribute("title", "Create Categories");
        model.addAttribute("category", new EventCategory());
        return "eventcategories/create";
    }

    @PostMapping("create")
    public String processCreateEventCategoryForm(@ModelAttribute @Valid EventCategory newCategory,
                                         Errors errors, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Categories: DO IT RIGHT THIS TIME!");
            return "eventcategories/create";
        }
        eventCategoryRepository.save(newCategory);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventCategoryForm(Model model) {
        model.addAttribute("title", "Delete Categories");
        model.addAttribute("eventCategories", eventCategoryRepository.findAll());
        return "eventcategories/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventCategoryForm(@RequestParam(required = false) int[] eventCategoryIds) {

        if (eventCategoryIds != null) {
            for (int id : eventCategoryIds) {
                eventCategoryRepository.deleteById(id);
            }
        }
        return "redirect:";
    }
}
