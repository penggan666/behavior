package com.example.behavior.Services;

import com.example.behavior.Repository.usersRepository;
import com.example.behavior.javabean.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class usersService {
    @Autowired
    private usersRepository usersRepository;

    //获取某一列的全部信息
    public List<String> getOneColumn(String columnName) {
        List<String> list = new ArrayList<>();
        switch (columnName) {
            case "edu":
                list = usersRepository.getAlledu();
                break;
            case "gender":
                list = usersRepository.getAllegender();
                break;
            case "isCity":
                list = usersRepository.getAllisCity();
                break;
            case "job":
                list = usersRepository.getAlljob();
                break;
            case "province":
                list = usersRepository.getAllprovince();
                break;
        }
        return list;
    }

    //获取某一列的所有属性
    public Set<String> getProperty(String columnName) {
        Set<String> set = new HashSet<>();
        List<String> list = getOneColumn(columnName);
        for (String s : list)
            set.add(s);
        return set;
    }

    //获取某一列某个属性的个数
    public Integer getNum(String columnName, String dataName) {
        List<String> list = getOneColumn(columnName);
        Integer sum = 0;
        for (String s : list) {
            if (s.equals(dataName))
                sum++;
        }
        return sum;
    }

    public List<Map> getResult(String columnName) {
        List<Map> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        List<String> list1 = getOneColumn(columnName);
        for (String s : list1) {
            if (map.get(s) != null)
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 0);
        }
        for (String s : map.keySet()) {
            Map map1 = new HashMap();
            map1.put("name", s);
            map1.put("value", map.get(s));
            list.add(map1);
        }
        return list;
    }

    public static String readTxttoString(File file) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            br.close();
            return String.valueOf(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> getMatchTime(String s) {
        Pattern p = Pattern.compile("(U<=>)(.*?)(\\[=])");
        Matcher m = p.matcher(s);
        List<String>  a =new ArrayList<String>();
        while (m.find()) if (!m.group(2).equals("NULL") ) a.add(m.group(2).trim());
        return  a;
    }

    //    public static Set<String> readTxt()//读取一个txt中的url
//    {
//        String basePath="H://data//behavior";
//        File file1=new File(basePath);
//        File[] timeFiles=file1.listFiles();
//        Set<String> allUrl=new HashSet<String>();
//        for(File f:timeFiles){
//            File[] dataFiles=f.listFiles();
//            for(File f_data:dataFiles){
//                String s=readTxttoString(f_data);
//                List<String> urlByRegex=getMatchTime(s);
//                for(String Url:urlByRegex){
//                    allUrl.add(Url);
//                }
//            }
//        }
//        return allUrl;
//    }
    public static String readUrl(File f)//读取一个txt中的url
    {
        String url = "";
        String s = readTxttoString(f);
        List<String> urlByRegex = getMatchTime(s);
        for (String Url : urlByRegex) {
            url = Url + '|';
        }
        return url;
    }

    public static HashMap<String, HashMap<String, String>> allurl()//读取所有url
    {
        String basePath = "H://data//behavior";
        File file1 = new File(basePath);
        HashMap<String, HashMap<String, String>> allData = new HashMap<String, HashMap<String, String>>();
        File[] timeFiles = file1.listFiles();
        for (File f : timeFiles) {
            File[] dataFiles = f.listFiles();
            HashMap<String, String> onePersonData = new HashMap<String, String>();
            for (File f_data : dataFiles) {
                String s = readUrl(f_data);
                onePersonData.put(f_data.getName().substring(33, 43), s);
                allData.put(f_data.getName().substring(0, 32), onePersonData);
            }
            System.out.println(1);
        }
        return allData;
    }

}
