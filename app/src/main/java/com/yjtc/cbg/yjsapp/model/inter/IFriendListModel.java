package com.yjtc.cbg.yjsapp.model.inter;

import com.yjtc.cbg.yjsapp.bean.User;

import java.util.List;

/**
 * Created by chenboge on 16/5/9.
 */
public interface IFriendListModel {

    String[] getIndexStr();

    List<User> getSortList();

}
