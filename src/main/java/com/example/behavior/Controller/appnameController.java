package com.example.behavior.Controller;

import com.example.behavior.Services.appnameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appnameController {
    @Autowired
    public appnameService appnameService;
    @GetMapping(value="/appname/insert")
    public void insert()
    {
        appnameService.saveApp();
    }
}
