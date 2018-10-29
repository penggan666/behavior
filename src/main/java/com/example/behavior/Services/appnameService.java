package com.example.behavior.Services;

import com.example.behavior.Repository.appnameRepository;
import com.example.behavior.Utils.appnameUtils;
import com.example.behavior.javabean.appname;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class appnameService {
    @Autowired
    public appnameRepository appnameRepository;
    public appnameUtils appnameUtils;
    public void saveApp(){
        List<appname> appname= appnameUtils.getAllapp();
        appnameRepository.saveAll(appname);
        System.out.println("finish");
    }
}
