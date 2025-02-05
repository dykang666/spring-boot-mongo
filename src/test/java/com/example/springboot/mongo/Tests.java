package com.example.springboot.mongo;

import com.example.springboot.mongo.domain.User;
import com.example.springboot.mongo.domain.UserUser;
import com.mongodb.client.result.DeleteResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2025/2/5 16:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
    /**
     * 小于：$lt
     * 小于或等于：$lte
     * 大于：$gt
     * 大于或等于：$gte
     * 不等于：$ne
     * 属于：$in
     */
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 新增数据
     */

    @Test
    public void insertData(){
        //向数据库插入点数据，用于测试下面的程序
        List<User> list = new ArrayList();
        for (int i=0; i<20; i++){
            User user = new User(String.valueOf((char)((int)('a')+i)),i,(char)((int)('a')+i)+"@qq.com",new Date(2018,5,i));
            list.add(user);
        }
        mongoTemplate.insert(list,"user1");
    }

    @Test
    public void insertData1(){
        //向数据库插入点数据，用于测试下面的程序
        List<User> list = new ArrayList();
        for (int i=0; i<20; i++){
            User user = new User(String.valueOf((char)((int)('a')+i)),i,(char)((int)('a')+i)+"@qq.com",new Date(2018,5,i));
            list.add(user);
        }
        mongoTemplate.insert(list,"userUser");
    }
    /**
     * 通过名称查询
     *    //根据查询条件返回所有匹配的记录
     *         //映射的表为指定的类名的首字母小写形式
     */
    @Test
    public void find1(){
        //根据查询条件返回所有匹配的记录
        //映射的表为指定的类名的首字母小写形式
        Query query = new Query(Criteria.where("username").is("c"));
        List<UserUser> list = mongoTemplate.find(query,UserUser.class);
        for (UserUser user : list) {
            System.out.println(user);
        }
    }

    /**
     * 通过名称查询 能查询到数据
     */
    @Test
    public void find2() {
        //指定表名根据查询条件返回所有匹配的记录
        Query query = new Query(Criteria.where("username").is("c"));
        List<UserUser> list = mongoTemplate.find(query, UserUser.class,"user1");
        for (UserUser user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void findAll1() {
        //查询表中所有记录
        //映射的表为指定的类名的首字母小写形式
        List<UserUser> list = mongoTemplate.findAll(UserUser.class);
        for (UserUser user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void findAll2() {
        //指定表名查询表中所有记录
        List<UserUser> list = mongoTemplate.findAll(UserUser.class,"user1");
        for (UserUser user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void findById1() {
        //根据ID查询表中记录
        //映射的表为指定的类名的首字母小写形式
        UserUser user = mongoTemplate.findById("67a3344a85fc4428eb978e52",UserUser.class);
        System.out.println(user);
    }

    @Test
    public void findById2() {
        //指定表名根据ID查询表中记录
        UserUser user = mongoTemplate.findById("67a3329b497910417e2d854e",UserUser.class,"user1");
        System.out.println(user);
    }


    @Test
    public void delete() {
        DeleteResult deleteResult = mongoTemplate.remove(new Query(Criteria.where("username").is("shuyan1")), UserUser.class);
        System.out.println(deleteResult);
    }

    @Test
    public void modify() {
        Query query = new Query(Criteria.where("username").is("ccc"));
        Update update = new Update().set("username", "cccbbb");
        FindAndModifyOptions options = new FindAndModifyOptions().returnNew(true);
        mongoTemplate.findAndModify(query, update, options, UserUser.class, "userUser");
    }



    @Test
    public void regex(){
        //db.userUser.find({username:{$regex:'^d'}})
        Query query = new Query(Criteria.where("username").regex("^d"));
        List<UserUser> list = mongoTemplate.find(query,UserUser.class);
        for (UserUser user : list) {
            System.out.println(user);
        }
    }

    /**
     * 小于：$lt
     * 小于或等于：$lte
     * 大于：$gt
     * 大于或等于：$gte
     * 不等于：$ne
     * 属于：$in
     */
    @Test
    public void compare(){
        //db.userUser.find({age:{$lt:10}})
        Query query = new Query(Criteria.where("age").lt(10));
        List<User> list = mongoTemplate.find(query,User.class,"user1");
        System.out.println("=================age lt 10 ==================");
        for (User user : list) {
            System.out.println(user);
        }
        //db.userUser.find({age:{$lte:10}})
        query = new Query(Criteria.where("age").lte(10));
        list = mongoTemplate.find(query,User.class,"user1");
        System.out.println("=================age lte 10 ==================");
        for (User user : list) {
            System.out.println(user);
        }
        //db.userUser.find({age:{$gt:10}})
        query = new Query(Criteria.where("age").gt(10));
        list = mongoTemplate.find(query,User.class,"user1");
        System.out.println("=================age gt 10 ==================");
        for (User user : list) {
            System.out.println(user);
        }
        //db.userUser.find({age:{$gte:10}})
        query = new Query(Criteria.where("age").gte(10));
        list = mongoTemplate.find(query,User.class,"user1");
        System.out.println("=================age gte 10 ==================");
        for (User user : list) {
            System.out.println(user);
        }
        //db.userUser.find({age:{$gte:10,$lt:18}})
        query = new Query(Criteria.where("age").gte(10).lt(18));
        list = mongoTemplate.find(query,User.class,"user1");
        System.out.println("================= 10 <= age < 18 ==================");
        for (User user : list) {
            System.out.println(user);
        }
    }


    /**
     * 小于：$lt
     * 小于或等于：$lte
     * 大于：$gt
     * 大于或等于：$gte
     * 不等于：$ne
     * 属于：$in
     */
    @Test
    public void page(){
        //db.userUser.find({age:{lt:10}}).skip(5*(1-1)).limit(5)
        Query query = new Query(Criteria.where("age").lt(10)).with(PageRequest.of(1,5));
        List<User> list = mongoTemplate.find(query,User.class,"user1");
        for (User user : list) {
            System.out.println(user);
        }
    }
    /**
     * 小于：$lt
     * 小于或等于：$lte
     * 大于：$gt
     * 大于或等于：$gte
     * 不等于：$ne
     * 属于：$in
     */
    @Test
    public void sort(){
        //db.userUser.find({age:{lt:10}}).sort(age:-1)  原生查询（JavaScript）
        Query query = new Query(Criteria.where("age").lt(10))
                .with(Sort.by(Sort.Direction.DESC, "age"));
        List<User> list = mongoTemplate.find(query,User.class,"user1");
        for (User user : list) {
            System.out.println(user);
        }
    }
}
