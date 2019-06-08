package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class DijkstraController {

    @GetMapping("/dijkstra.html")
    public String getDijkstra(){
        return "dijkstra";
    }

}
