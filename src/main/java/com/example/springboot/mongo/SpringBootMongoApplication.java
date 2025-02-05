package com.example.springboot.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * 参考  https://github.com/Mshuyan/spring-data-mongodb/
 * MongoDB 特别适用于以下场景：
 *
 * 大数据存储：例如日志、传感器数据、社交网络数据等。
 * 实时分析与报告：需要快速存取和分析大量数据的应用。
 * 快速迭代的应用：数据模型经常变化的项目，比如初创公司开发的 MVP。
 * 文档型数据存储：适合存储 JSON 或 BSON 格式的结构化和半结构化数据。
 * @date 2025/2/5 16:20
 */
@SpringBootApplication
public class SpringBootMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongoApplication.class, args);
    }

}
