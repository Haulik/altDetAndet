package com.example.restapi.bootstrap;

import com.example.restapi.Repositories.CategoryRepository;
import com.example.restapi.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Spring er startet");
        Category fodboldhold = new Category();
        fodboldhold.setName("fodboldhold");

        Category biler = new Category();
        biler.setName("biler");

        categoryRepository.save(fodboldhold);
        categoryRepository.save(biler);
        System.out.println("Gemt antal objekter: " + categoryRepository.count());

    }
}
