package com.yjtc.cbg.yjsapp.fragment.inter;

import com.yjtc.cbg.yjsapp.Adapter.Art;
import com.yjtc.cbg.yjsapp.bean.Banner;
import com.yjtc.cbg.yjsapp.bean.User;

import java.util.List;

/**
 * Created by chenboge on 16/4/30.
 */
public interface IChatFragment {


    void refresh();

    void loadListView(List<User> users);


}
