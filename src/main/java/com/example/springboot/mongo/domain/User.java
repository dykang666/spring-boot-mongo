package com.example.springboot.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/2/5 16:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String username;
    private int age;
    private String email;
    private Date birthday;
}
