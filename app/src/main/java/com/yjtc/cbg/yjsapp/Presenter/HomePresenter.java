package com.yjtc.cbg.yjsapp.Presenter;

import com.yjtc.cbg.yjsapp.fragment.inter.IHomeFragment;
import com.yjtc.cbg.yjsapp.model.HomeModel;
import com.yjtc.cbg.yjsapp.model.inter.IHome;

/**
 * Created by chenboge on 16/4/30.
 */
public class HomePresenter {

    private IHome home=new HomeModel();
    private IHomeFragment iHomeFragment;

    public HomePresenter(IHomeFragment iHomeFragment) {
        this.iHomeFragment = iHomeFragment;
    }

    public void initSlider(){
        iHomeFragment.initSliderViewData(home.getBanners());
    }

    public void initGridView(){
        iHomeFragment.initGridView(home.getArts());
    }


}
