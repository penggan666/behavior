package com.example.behavior.Utils;

import com.example.behavior.javabean.UserTime;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class timeUtil {
    public static String readLast(File file)
    {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line=br.readLine();
            br.close();
            return line;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static java.sql.Date strToDate(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        return date;
    }
    public static java.sql.Time strToTime(String strDate) {
        String str = strDate;
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        Date d = null;
        try {
            d = format.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Time time = new java.sql.Time(d.getTime());
        return time;
    }
    public static List<UserTime> allData ()
    {
        int num=1;
        String basePath = "H:\\课程相关\\导师学习记录\\Data\\互联网用户行为日志数据集.rardataset_616718\\data\\behavior";
        File file1 = new File(basePath);
        List <UserTime>  user_time=new ArrayList<>();
        File[] timeFiles = file1.listFiles();
        for (File f : timeFiles) {
            File[] dataFiles = f.listFiles();
            for (File f_data : dataFiles) {
                String a=f_data.getName().substring(0,32);
                String b=f_data.getName().substring(33,43);
                String c=f_data.getName().substring(44,52);
                String d1=readLast(f_data);
                int len=d1.length();
                String d=d1.substring(7,len);
                UserTime time=new UserTime();
                int D=Integer.valueOf(d);
                java.sql.Date date=strToDate(b);
                java.sql.Time times=strToTime(c);
                time.setId(num++);
                time.setUserId(a);
                time.setStartDate(date);
                time.setStartTime(times);
                time.setLenTime(D);
                user_time.add(time);
                System.out.println(num);
            }
        }
        return user_time;
    }
}
