package com.gaohx.springbootlearningvalidation.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {
    @NotNull(message = "name不能为空")
    private String name;
    @Min(message = "不能小于10",value = 10)
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
