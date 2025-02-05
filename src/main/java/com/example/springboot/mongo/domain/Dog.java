package com.example.springboot.mongo.domain;

import org.springframework.data.annotation.Id;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/2/5 16:17
 */
public class Dog {
    @Id
    private String id;
    private String username;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Dog(String username) {
        this.username = username;
    }
}
