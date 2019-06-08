package com.example.restapi.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class Categories {
    private List<Category> categories;
}
