package com.example.behavior.Controller;

import com.example.behavior.Repository.usersRepository;
import com.example.behavior.Services.usersService;
import com.example.behavior.javabean.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class usersController {
    @Autowired
    private usersRepository usersRepository;
    @Autowired
    private usersService usersService;


    //获取所有人信息
    @GetMapping(value = "/users")
    public List<users> findAll() {
        return usersRepository.findAll();
    }

    //获取教育信息
    @GetMapping(value = "/users/edu")
    public List<Map> getEdu() {
        return usersService.getResult("edu");
    }

    //获取性别信息
    @GetMapping(value = "/users/gender")
    public List<Map> getGender() {
        return usersService.getResult("gender");
    }

    //获取省份信息
    @GetMapping(value = "/users/province")
    public List<Map> getProvince() {
        return usersService.getResult("province");
    }

    //获取iscity信息
    @GetMapping(value = "/users/isCity")
    public List<Map> getisCity() {
        return usersService.getResult("isCity");
    }

    //获取工作信息
    @GetMapping(value = "/users/job")
    public List<Map> getJob() {
        return usersService.getResult("job");
    }

    //
}
