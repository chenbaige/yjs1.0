package com.yjtc.cbg.yjsapp.model.inter;

import com.yjtc.cbg.yjsapp.Adapter.Art;
import com.yjtc.cbg.yjsapp.bean.Banner;

import java.util.List;

/**
 * Created by chenboge on 16/5/6.
 */
public interface IMineModel {

    List<Banner> getBanners();

    List<Art> getArts();
}
