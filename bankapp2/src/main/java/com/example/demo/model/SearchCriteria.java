package com.example.demo.model;

import javax.validation.constraints.NotEmpty;

public class SearchCriteria {

   // @NotEmpty
   private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public SearchCriteria(String username) {
        this.username = username;
    }
    public SearchCriteria() {

    }
}
