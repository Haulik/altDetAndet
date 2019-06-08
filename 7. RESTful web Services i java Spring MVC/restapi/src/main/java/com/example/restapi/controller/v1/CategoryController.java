package com.example.restapi.controller.v1;

import com.example.restapi.model.Categories;
import com.example.restapi.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/v1/categories/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Categories> getAllCategories(){
        return new ResponseEntity<>(new Categories(categoryService.getAllCategories()), HttpStatus.OK);
    }
}
