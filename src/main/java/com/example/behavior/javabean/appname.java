package com.example.behavior.javabean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class appname {
    @Id
    int num;
    String userid;
    String appname;
    public void appname(){}

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }
}
