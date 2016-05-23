package com.yjtc.cbg.yjsapp.bean;

/**
 * Created by chenboge on 16/4/29.
 */
public class User {

    private String UserName;

    public User(String userName) {
        UserName = userName;
    }

    public User(String userName, String pinYinName, String passWord) {
        UserName = userName;
        this.pinYinName = pinYinName;
        PassWord = passWord;
    }

    public String getPinYinName() {

        return pinYinName;
    }

    public void setPinYinName(String pinYinName) {
        this.pinYinName = pinYinName;
    }

    private String pinYinName;

    public User(String userName, String passWord) {
        UserName = userName;
        PassWord = passWord;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassWord() {
        return PassWord;
    }

    public void setPassWord(String passWord) {
        PassWord = passWord;
    }

    private String PassWord;
}
