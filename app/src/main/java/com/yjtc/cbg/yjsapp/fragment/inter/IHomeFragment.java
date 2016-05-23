package com.yjtc.cbg.yjsapp.fragment.inter;

import com.yjtc.cbg.yjsapp.Adapter.Art;
import com.yjtc.cbg.yjsapp.bean.Banner;

import java.util.List;

/**
 * Created by chenboge on 16/4/30.
 */
public interface IHomeFragment {

    void initSliderViewData(List<Banner> banners);

    void initGridView(List<Art> arts);
}
