package com.example.springboot.mongo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/2/5 16:19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "userUser")
public class UserUser {
    @Id
    private String id;
    private String username;
}
