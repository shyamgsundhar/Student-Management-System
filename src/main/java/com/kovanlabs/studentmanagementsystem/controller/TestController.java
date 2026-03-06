package com.kovanlabs.studentmanagementsystem.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DataSource dataSource;

    @RequestMapping("/test")
    public String test(){

        try {
            Connection conn = dataSource.getConnection();
            conn.close();

            return "Spring MVC is working! | DB Connected Successfully ";

        } catch (Exception e) {

            return "Spring MVC is working! | DB Connection Failed " + e.getMessage();
        }
    }
}