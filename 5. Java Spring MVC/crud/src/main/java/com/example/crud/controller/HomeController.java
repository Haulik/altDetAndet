package com.example.crud.controller;

import com.example.crud.model.Person;
import com.example.crud.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    IPersonService personService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("persons", personService.fetchAll());
        return "index";
    }

    @PostMapping("/create")
    public String create(Person person){
        personService.addPerson(person);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String update(Person person){
        System.out.println("modtaget person: " + person.getFirst_name());
        personService.updatePerson(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id){
        personService.deletePerson(id);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") int id, Model model){
       Person person = personService.findPersonById(id);
       model.addAttribute("person", person);
       return "update";
    }
}
