package com.example.behavior.Services;

import com.example.behavior.Repository.timeRepository;
import com.example.behavior.javabean.UserTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class timeService {
    @Autowired
    public timeRepository timeRepository;
    public void save(){
       List<UserTime> U= com.example.behavior.Utils.timeUtil.allData();
       timeRepository.saveAll(U);
       System.out.println("finish");
    }
    public Map<String,Integer> findTime(String str)
    {
        java.sql.Date date=com.example.behavior.Utils.timeUtil.strToDate(str);
        List<UserTime> list=timeRepository.findAllByStartDate(date);
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(UserTime u:list)
        {
            if(map.containsKey(u.getUserId())==false)
                map.put(u.getUserId(),u.getLenTime());
            else {
                Integer sum=map.get(u.getUserId())+u.getLenTime();
                map.put(u.getUserId(), sum);
            }
        }
        return map;
    }
    public Map<Integer,Integer> sumTime(Map<String,Integer> m2)
    {
        Map<Integer,Integer> m1=new HashMap<>();
        for(int i=0;i<=23;i++)
            m1.put(i,0);
        for (Map.Entry<String,Integer> entry : m2.entrySet()) {
            Integer hour=entry.getValue()/3600;
            if(m1.containsKey(hour))
            {
                m1.put(hour,m1.get(hour)+1);
            }
            else
                m1.put(23,m1.get(23)+1);
        }
        return m1;

    }
    public List<Map> getallDate() {
        String basePath = "H:\\课程相关\\导师学习记录\\Data\\互联网用户行为日志数据集.rardataset_616718\\data\\behavior";
        File file1 = new File(basePath);
        List<Map> Date = new ArrayList<>();
        File[] timeFiles = file1.listFiles();
        Map<String,Integer> m=new HashMap<>();
        for (File f : timeFiles) {
                String a=f.getName();
                m.put(a,1);
            }
        for (String s : m.keySet()) {
            Map map1 = new HashMap();
            map1.put("name", s);
            map1.put("value", m.get(s));
            Date.add(map1);
        }
        return Date;
    }


}

