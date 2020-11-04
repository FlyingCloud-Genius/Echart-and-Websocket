package org.example.demo.domain;

import lombok.Data;

import java.util.List;

@Data
public class Man {

    private String name;

    private Integer age;

    private Boolean sex;

    private Integer weight;

    private Integer height;

    private List<String> love;
}
