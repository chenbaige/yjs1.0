package com.yjtc.cbg.yjsapp.model;

import com.yjtc.cbg.yjsapp.bean.User;
import com.yjtc.cbg.yjsapp.model.inter.IChatModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenboge on 16/5/9.
 */
public class ChatModel implements IChatModel {
    @Override
    public List<User> getUser() {
        List<User> mDatas = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mDatas.add(new User("海绵宝宝", "123456"));
        }
        return mDatas;
    }
}
