package com.yjtc.cbg.yjsapp.model;

import com.yjtc.cbg.yjsapp.bean.Banner;
import com.yjtc.cbg.yjsapp.model.inter.IAuctioningModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenboge on 16/5/12.
 */
public class AuctioningModel implements IAuctioningModel {


    @Override
    public List<Banner> getBanners() {
        List<Banner> banners = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Banner banner = new Banner("功能" + i, "https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1462346059&di=44d1d336abaab39bb6bd08a53d80b9d9&src=http://imgditan.cang.com/201408/29/201408291227561098199.JPG");
            banners.add(banner);
        }
        return banners;
    }
}
