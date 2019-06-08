package com.example.demo;

import com.example.demo.model.GoldenCow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<GoldenCow> cows = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("brugere",cows);
        return "index";

    }

    @PostMapping("/addUser")
    public String addUser(GoldenCow cow){
        System.out.println("har modtaget cow: " + cow);
        cows.add(cow);
        return "redirect:/";
    }
}
