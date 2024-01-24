package com.example.ToDo.List.App.controller;

import com.example.ToDo.List.App.model.ToDoListModel;
import com.example.ToDo.List.App.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

public class ToDoListController {
    @Controller
    @RequiredArgsConstructor
    @RequestMapping("todolist")
    public class ToDoController {
        private final ToDoListService toDoListService;

        @GetMapping("/all")
        public String getAll (Model model) {
            model.addAttribute("list", toDoListService.getAll());
            return "listDir/all";
        }

        @PostMapping("/add")
        public String saveAll (@ModelAttribute ToDoListModel toDoListModel) {
            toDoListService.save(toDoListModel);
            return "redirect:/todolist/all";
        }
        @GetMapping("/{id}")
        public String getOneListItemById (Model model, @PathVariable Long id) {
            model.addAttribute("oneItem", toDoListService.getOne(id));
            return "listDir/one";
        }

        @PostMapping("/edit/{id}")
        public String updateAll (@PathVariable Long id, @ModelAttribute ToDoListModel toDoListModel) {
            toDoListService.update(id,toDoListModel);
            return "redirect:/todolist/" + id;
        }

        @GetMapping("/delete/{id}")
        public String deleteItem (@PathVariable Long id) {
            toDoListService.deleteById(id);
            return "redirect:/todolist/all";
        }

    }

}
