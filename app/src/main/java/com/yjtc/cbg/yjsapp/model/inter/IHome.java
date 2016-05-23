package com.yjtc.cbg.yjsapp.model.inter;



import android.app.Fragment;

import com.yjtc.cbg.yjsapp.Adapter.Art;
import com.yjtc.cbg.yjsapp.bean.Banner;

import java.util.List;

/**
 * Created by chenboge on 16/4/30.
 */
public interface IHome {
    List<Fragment> getFragments();

    List<Banner> getBanners();

    List<Art> getArts();
}
