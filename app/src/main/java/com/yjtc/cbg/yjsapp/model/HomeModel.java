package com.yjtc.cbg.yjsapp.model;


import android.app.Fragment;

import com.yjtc.cbg.yjsapp.Adapter.Art;
import com.yjtc.cbg.yjsapp.bean.Banner;
import com.yjtc.cbg.yjsapp.fragment.ChatFragment;
import com.yjtc.cbg.yjsapp.fragment.HomeFragment;
import com.yjtc.cbg.yjsapp.fragment.MineFragment;
import com.yjtc.cbg.yjsapp.fragment.SchoolFragment;
import com.yjtc.cbg.yjsapp.fragment.ShopFragment;
import com.yjtc.cbg.yjsapp.model.inter.IHome;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenboge on 16/4/30.
 */
public class HomeModel implements IHome {

    private List<Fragment> mfragments;

    @Override
    public List<Fragment> getFragments() {
        mfragments = new ArrayList<>();
        mfragments.add(new HomeFragment());
        mfragments.add(new SchoolFragment());
        mfragments.add(new ShopFragment());
        mfragments.add(new ChatFragment());
        mfragments.add(new MineFragment());
        return mfragments;
    }

    @Override
    public List<Banner> getBanners() {
        List<Banner> banners = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Banner banner = new Banner("", "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1462346059&di=44d1d336abaab39bb6bd08a53d80b9d9&src=http://imgditan.cang.com/201408/29/201408291227561098199.JPG");
            banners.add(banner);
        }
        return banners;
    }

    @Override
    public List<Art> getArts() {
        List<Art> arts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arts.add(new Art());
        }
        return arts;
    }
}
