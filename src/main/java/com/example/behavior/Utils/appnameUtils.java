package com.example.behavior.Utils;

import com.example.behavior.javabean.appname;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class appnameUtils {
    public static List<String> getMatch(String s)
    {
        Pattern p = Pattern.compile("(N<=>)(.*?)(\\[=])");
        Matcher m = p.matcher(s);
        List<String>  a =new ArrayList<String>();
        while (m.find()) if (!m.group(2).equals("NULL") ) a.add(m.group(2).trim());
        return  a;
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
    public static List<appname> getAllapp()
    {
        int num=1;
        String basePath = "H:\\课程相关\\导师学习记录\\Data\\互联网用户行为日志数据集.rardataset_616718\\data\\behavior";
        File file1 = new File(basePath);
        List <appname>  appname=new ArrayList<>();
        File[] timeFiles = file1.listFiles();
        for (File f : timeFiles) {
            File[] dataFiles = f.listFiles();
            for (File f_data : dataFiles) {
                String a=f_data.getName().substring(0,32);
                String s=readTxttoString(f_data);
                List<String> list=getMatch(s);
                for(String ss:list)
                {
                    appname app=new appname();
                    app.setNum(num++);
                    app.setUserid(a);
                    app.setAppname(ss);
                    appname.add(app);
                    System.out.println(ss);
                }
            }
        }
        return appname;
    }

}
