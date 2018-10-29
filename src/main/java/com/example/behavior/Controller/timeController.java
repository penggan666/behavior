package com.example.behavior.Controller;

import com.example.behavior.Services.timeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class timeController {
    @Autowired
    public timeService timeService;
    @GetMapping(value = "/usertime/insert")
    public void insert()
    {
        timeService.save();
    }
    @GetMapping(value = "/usertime/findtime")
    public Map<String, List> findtime(@RequestParam("date") String s)
    {
        Map<String,Integer> m=timeService.findTime(s);
        Map<Integer,Integer> m1=timeService.sumTime(m);
        List<Integer> l1=new ArrayList<>();
        List<String> l2=new ArrayList<>();
        for (Map.Entry<Integer,Integer> entry : m1.entrySet()){
            l1.add(entry.getValue());
            l2.add(String.valueOf(entry.getKey())+"-"+String.valueOf(entry.getKey()+1));
        }
        Map<String,List> m2=new HashMap<>();
        m2.put("yvalue",l1);
        m2.put("xvalue",l2);
        return m2;
    }
    @GetMapping(value = "/usertime/alldate")
    public List<Map> getDate(){
        return timeService.getallDate();
    }
}
