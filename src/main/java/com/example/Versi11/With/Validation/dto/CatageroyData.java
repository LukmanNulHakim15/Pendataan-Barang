package com.example.Versi11.With.Validation.dto;

import javax.validation.constraints.NotEmpty;

public class CatageroyData {

    @NotEmpty(message = "Name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
