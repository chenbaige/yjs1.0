package com.yjtc.cbg.yjsapp.View.inter;

import com.yjtc.cbg.yjsapp.Adapter.Art;
import com.yjtc.cbg.yjsapp.bean.Banner;

import java.util.List;

/**
 * Created by chenboge on 16/5/6.
 */
public interface IMineActivity {

    void initGalleryData(List<Banner> banners);

    void initContentData(List<Art> arts);

}
