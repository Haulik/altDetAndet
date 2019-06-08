package com.example.demo.controller;

import com.example.demo.model.AjaxResponseBody;
import com.example.demo.model.GoldenCow;
import com.example.demo.model.SearchCriteria;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class SearchController {

    @Autowired
    private UserService userService;

    @PostMapping("api/search")
    public ResponseEntity<?> getSearchResult(@Valid @RequestBody SearchCriteria s, Errors errors) {
        System.out.println("getSearch kaldt");
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        GoldenCow cow = userService.findCow(s.getUsername());
        if (cow == null) {
            ajaxResponseBody.setMsg("user not found");
        } else {
            ajaxResponseBody.setMsg("User found");
            ajaxResponseBody.setCow(cow);
        }
        if (s.getUsername().length() == 0){
            ajaxResponseBody.setMsg("Enter at least on char");
        return ResponseEntity.badRequest().body(ajaxResponseBody);
    }
        return ResponseEntity.ok(ajaxResponseBody);
    }
}
