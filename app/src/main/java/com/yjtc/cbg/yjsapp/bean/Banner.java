package com.yjtc.cbg.yjsapp.bean;

/**
 * Created by chenboge on 16/4/30.
 */
public class Banner {
    public Banner(String name, String imgUrl) {
        Name = name;
        ImgUrl = imgUrl;
    }

    private String Name;
    private String ImgUrl;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }
}
